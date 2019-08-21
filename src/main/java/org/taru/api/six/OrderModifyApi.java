package org.taru.api.six;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.Order;
import org.taru.entity.OrderrVo;
import org.taru.service.six.OrderModifyInterface;
import org.taru.service.six.OrderOne;
import org.taru.vo.JsonResult;

import java.util.HashMap;
import java.util.List;

@Controller
@CrossOrigin(allowCredentials = "true")
public class OrderModifyApi {
    @Autowired
    OrderModifyInterface m;
    /**
     * 修改订单api
     */
    @RequestMapping(value = "/api/orderModify",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult orderQuary(@Param("id")int  id,
                                 @Param("OrderPrice")String orderPrice,
                                 @Param("orderUserIndate")String orderUserIndate,
                                 @Param("orderUserOutdate")String orderUserOutdate ){
        HashMap hashMap=new HashMap();
        hashMap.put("id",id);
        hashMap.put("orderPrice",orderPrice);
        hashMap.put("orderUserIndate",orderUserIndate);
        hashMap.put("orderUserOutdate",orderUserOutdate);
        int i=m.orderModifyInterface(hashMap);
        JsonResult json=null;
        try{
            if(i!=0){
                json=new JsonResult("200","修改成功",null);
            }else {
                json=new JsonResult("404","修改失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            json=new JsonResult("500","查询异常",e.getMessage());
        }
        return json;
    }
}
