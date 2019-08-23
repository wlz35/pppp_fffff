package org.taru.api.five;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.Style;
import org.taru.service.five.StyleService;
import org.taru.vo.JsonResult;

import java.util.List;

@Controller
public class StyleApi {
    @Autowired
    StyleService impl;

    /**
     * 查询风格（style）的说有信息
     * @return
     */
    @CrossOrigin
    @RequestMapping("/api/queryallstyle")
    @ResponseBody
    public JsonResult queryStyleApi(){
        JsonResult jsonResult = null;
        try {
            List list = impl.queryStyleService();
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
     * 添加风格（style）
     * @param style
     * @return
     */
    @CrossOrigin
    @RequestMapping("/api/addstyle")
    @ResponseBody
    public JsonResult addStyleApi(Style style){
        JsonResult jsonResult = null;
        try {
            int row = impl.addStyleService(style);
            if(row!=1){
                jsonResult = new JsonResult("500","添加异常","");
            }else{
                jsonResult = new JsonResult("200","添加成功","");
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","error","");
        }
        return jsonResult;
    }


    /**
     * 根据ID修改风格
     * @param style
     * @return
     */
    @CrossOrigin
    @RequestMapping("/api/updatestyle")
    @ResponseBody
    public JsonResult updateStyleApi(Style style){
        JsonResult jsonResult = null;
        try {
            int row = impl.updateStyleService(style);
            if(row!=1){
                jsonResult = new JsonResult("500","修改异常","");
            }else{
                jsonResult = new JsonResult("200","修改成功","");
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","error","");
        }
        return jsonResult;
    }


    /**
     * 根据ID逻辑删除
     * @param styleId
     * @return
     */
    @CrossOrigin
    @RequestMapping("/api/deletestyle")
    @ResponseBody
    public JsonResult deleteStyleApi(int styleId){
        JsonResult jsonResult = null;
        try {
            int row = impl.deleteStyleService(styleId);
            if(row!=1){
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
