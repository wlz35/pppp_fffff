package org.taru.api.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.Order;
import org.taru.service.three.QueryorderbyIdService;
import org.taru.vo.JsonResult;

/**
 * 根据订单ID查询订单详情
 */
@Controller
public class Orderdetail {
    @Autowired
    QueryorderbyIdService queryorderbyId;
    @CrossOrigin
    @RequestMapping("/api/queryorderbyId")
    @ResponseBody
    public JsonResult queryPri(int orderId){
        JsonResult jsonclass = null;
        try {
            Order order = queryorderbyId.queryorder(orderId);
            if(order==null){
                jsonclass = new JsonResult("400","查询详情失败","");
            }else{
                jsonclass = new JsonResult("200","查询详情成功",order);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonclass = new JsonResult("500","error","");
        }

        return jsonclass;
    }
}
