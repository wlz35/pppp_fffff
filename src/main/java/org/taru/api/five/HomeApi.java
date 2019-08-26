package org.taru.api.five;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.Home;
import org.taru.service.five.HomeService;
import org.taru.vo.JsonResult;

import java.util.List;

@Controller
public class HomeApi {
    @Autowired
    HomeService impl;

    /**
     * 查询所有房源信息
     * @return
     */

//    @ApiOperation(value = "测试swagger下拉框")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "type", value = "类型", dataType = "String")})
    @ApiOperation(value="查询所有房源信息",notes="无参数")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", defaultValue = "1", value = "订单Id", required = true, paramType = "int"),
//            @ApiImplicitParam(name = "OrderPrice", defaultValue = "1", value = "订单价格", required = true, paramType = "String"),
//            @ApiImplicitParam(name = "orderUserIndate", defaultValue = "1", value = "订单开始时间", required = true, paramType = "String"),
//            @ApiImplicitParam(name = "OrderPrice", defaultValue = "1", value = "订单结束时间", required = true, paramType = "String")
//    })
    @RequestMapping(value = "/apih/queryallhome", method = {RequestMethod.GET})
    @CrossOrigin
    @ResponseBody
    public JsonResult queryHomeApi(){
        JsonResult jsonResult = null;
        try {
           List list = impl.queryHomeService();
            if(list==null){
                jsonResult = new JsonResult("500","查询异常","");
            }else{
                jsonResult = new JsonResult("200","查询成功",list);
        }

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","error","");
        }
        return jsonResult;
    }


    /**
     * 添加房源信息
     * @param home
     * @return
     */
//    @CrossOrigin
//    @RequestMapping("/api/addhome")
//    @ResponseBody
//    public JsonResult addHomeApi(Home home){
//        JsonResult jsonResult = null;
//        try {
//            int row  = impl.addHomeService(home);
//            if(row==0){
//                jsonResult = new JsonResult("500","添加异常","");
//            }else{
//                jsonResult = new JsonResult("200","添加成功","");
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            jsonResult = new JsonResult("500","error","");
//        }
//        return jsonResult;
//    }





    /**
     * 根据房源ID（home_id）逻辑删除房源信息
     * @param homeId
     * @return
     */



    @ApiOperation(value="根据房源ID逻辑删除房源信息",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "homeId", value = "房源Id", required = true, paramType = "int"),
    })
    @RequestMapping(value = "/apih/deletehome",method = RequestMethod.GET)

    @CrossOrigin
    @ResponseBody
    public JsonResult deleteHomeApi(int homeId){
        JsonResult jsonResult = null;
        try {
            int row  = impl.deleteHomeService(homeId);
            if(row==0){
                jsonResult = new JsonResult("500","删除异常","");
            }else{
                jsonResult = new JsonResult("200","删除成功","");
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","error","");
        }
        return jsonResult;
    }





    /**
     * 根据房源ID修改房源信息
     * @param home
     * @return
     */

    @ApiOperation(value="根据房源ID修改房源信息",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "homeName",  value = "房源名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeAddress",  value = "房源地址", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homePrice",  value = "房源价格", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeInDate",  value = "顾客入住时间", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeOutDate",  value = "顾客退房时间", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeId",  value = "房源ID", required = true, paramType = "int")
    })
    @RequestMapping(value = "/apih/updatehome",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public JsonResult updateHomeApi(Home home){
        JsonResult jsonResult = null;
        try {
            int row  = impl.updateHomeService(home);
            if(row==0){
                jsonResult = new JsonResult("500","删除异常","");
            }else{
                jsonResult = new JsonResult("200","删除成功","");
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","error","");
        }
        return jsonResult;
    }
}
