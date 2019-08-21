package org.taru.api.six;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    @RequestMapping(value = "/api/order",method = RequestMethod.GET)
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
