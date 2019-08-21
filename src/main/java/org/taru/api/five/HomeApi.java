package org.taru.api.five;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @CrossOrigin
    @RequestMapping("/api/queryallhome")
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
    @CrossOrigin
    @RequestMapping("/api/deletehome")
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
    @CrossOrigin
    @RequestMapping("/api/updatehome")
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
