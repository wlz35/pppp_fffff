package org.taru.api.two;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.taru.vo.two.Home;
import org.taru.vo.two.Order;
import org.taru.service.two.OrderService;
import org.taru.vo.JsonResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
public class OrderServlet {
    @Autowired
    OrderService orderService;

    /**
     * 插入订单
     * @param order
     * @return
     */
    @ApiOperation(value = "插入订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order", defaultValue = "1", value = "order", required = true, paramType = "Object"),
    })
    @RequestMapping(value = "/api/order/commit1", method = RequestMethod.POST)
    public JsonResult insertOrderCommit2(Order order){
        JsonResult jsonResult = null;
        try{
            int order1 = orderService.insertOrderCommit1(order);
            if(order1 != 0){
                jsonResult = new JsonResult("200","提交订单成功",order1);
            }else {
                jsonResult = new JsonResult("400","提交订单失败",null);
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","服务器异常", e.getMessage());
        }
        return jsonResult;
    }



}
