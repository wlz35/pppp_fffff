package org.taru.api.six;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.Order;
import org.taru.entity.OrderrVo;
import org.taru.service.six.OrderInterface;
import org.taru.vo.JsonResult;

import java.util.List;

@Controller
@CrossOrigin(allowCredentials = "true")
public class OrderId {
@Autowired
OrderInterface o;

    /**
     * 查询所有订单api
     */
    @ApiOperation(value="查询所有订单方法",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", defaultValue = "1", value = "当前页", required = true, paramType = "int"),
            @ApiImplicitParam(name = "pageSize", defaultValue = "1", value = "每页条数", required = true, paramType = "int")
    })
    @RequestMapping(value = "/apih/order",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult orderQuary(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<OrderrVo> list=o.orderInterface();
        PageInfo pageInfo=new PageInfo(list);

        JsonResult json=null;
        try{
            if(list.size()>0){
                json=new JsonResult("200","查询成功",pageInfo);
            }else {
                json=new JsonResult("404","查询失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            json=new JsonResult("500","查询异常",null);
        }
        return json;
    }

}
