package org.taru.api.six;

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
import org.taru.entity.OrderrVo;
import org.taru.service.six.OrderOne;
import org.taru.vo.JsonResult;

import java.util.List;
@Controller
@CrossOrigin(allowCredentials = "true")
public class OrderOneApi {
    @Autowired
    OrderOne o;
    /**
     * 根据 用户id查询订单api
     */
    @ApiOperation(value="根据用户ID查询订单方法",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", defaultValue = "1", value = "用户ID", required = true, paramType = "int"),
    })
    @RequestMapping(value = "/apih/orderOne",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult orderQuary(@Param("id")int id){
        List<OrderrVo> list=o.orderOneInterface(id);
        JsonResult json=null;
        try{
            if(list.size()>0){
                json=new JsonResult("200","查询成功",list);
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
