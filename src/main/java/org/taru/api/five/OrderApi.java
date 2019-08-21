package org.taru.api.five;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.service.five.OrderService;
import org.taru.vo.JsonResult;

import java.util.Date;

@Controller
public class OrderApi {
    @Autowired
    OrderService impl;

    @CrossOrigin
    @RequestMapping("/api/queryprice")
    @ResponseBody
    public JsonResult queryHomeApi(int homeId, String homeInDate, String homeOutDate){
        JsonResult jsonResult = null;
        try {
            int allPrice = impl.queryMoney(homeId,homeInDate,homeOutDate);
            if(allPrice==0){
                jsonResult = new JsonResult("500","查询异常","");
            }else{
                jsonResult = new JsonResult("200","查询成功",allPrice);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","error","");
        }
        return jsonResult;
    }
}
