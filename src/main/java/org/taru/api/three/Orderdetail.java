package org.taru.api.three;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.Order;
import org.taru.service.three.QueryorderbyIdService;
import org.taru.vo.JsonResult;

import java.util.List;

/**
 * 根据订单ID查询订单详情
 */
@Controller
public class Orderdetail {
    @Autowired
    QueryorderbyIdService queryorderbyId;


    @ApiOperation(value="根据订单ID查询订单详情",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "订单ID", required = true, paramType = "int")
    })
    @RequestMapping(value = "/api/queryorderbyId",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public JsonResult queryPri(int userid){
        JsonResult jsonclass = null;
        try {
            List<Order> order = queryorderbyId.queryorder(userid);
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
