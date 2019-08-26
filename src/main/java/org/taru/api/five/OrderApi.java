package org.taru.api.five;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.service.five.OrderFiveService;
import org.taru.vo.JsonResult;


@Controller
public class OrderApi {
    @Autowired
    OrderFiveService impl;



    @ApiOperation(value="根据房源ID,用户入住和退房时间查询(返回)总价格同时向数据库插入订单信息",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户ID", required = true, paramType = "int"),
            @ApiImplicitParam(name = "homeId",value = "房源ID", required = true, paramType = "int"),
            @ApiImplicitParam(name = "homeInDate",value = "用户入住日期", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeOutDate",value = "用户退房日期", required = true, paramType = "String")
    })
    @RequestMapping(value = "/api/queryprice",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public JsonResult queryOrderApi(int userId, int homeId, String homeInDate, String homeOutDate){
        JsonResult jsonResult = null;
        try {
            int orderPrice = impl.queryMoney(userId,homeId,homeInDate,homeOutDate);
            if(orderPrice==0){
                jsonResult = new JsonResult("500","查询异常","");
            }else{
                jsonResult = new JsonResult("200","查询成功",orderPrice);
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","error","");
        }
        return jsonResult;
    }
}