package org.taru.api.one;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.taru.service.one.StoryService;
import org.taru.vo.JsonResult;
import org.taru.vo.one.Storyss;

import java.util.List;

@CrossOrigin
@RestController
public class StoryApi {

    @Autowired
    StoryService service;

    @RequestMapping(value = "/api/story/queryAll",method = RequestMethod.GET)
    public JsonResult queryAllStory(){
        JsonResult jsonResult = null;
        try{
            List<Storyss> list = service.queryAllStory();
            if(list!=null){
                jsonResult = new JsonResult("200","查询故事成功",list);
            }else {
                jsonResult = new JsonResult("404","查询故事失败","");
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","网络异常","");
        }
        return jsonResult;
    }

    @RequestMapping(value = "/api/story/queryByCity",method = RequestMethod.GET)
    public JsonResult queryStoryByCity(String storyCity){
        JsonResult jsonResult = null;
        try{
            List<Storyss> list = service.queryStoryByCity(storyCity);
            if(list!=null){
                jsonResult = new JsonResult("200","查询故事成功",list);
            }else {
                jsonResult = new JsonResult("404","查询故事失败","");
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","网络异常","");
        }
        return jsonResult;
    }

    @RequestMapping(value = "/api/story/queryByStoryId",method = RequestMethod.GET)
    public JsonResult queryStoryById(String storyId){
        JsonResult jsonResult = null;
        try{
            Storyss story = service.queryStoryById(storyId);
            if(story!=null){
                jsonResult = new JsonResult("200","查询故事成功",story);
            }else {
                jsonResult = new JsonResult("404","查询故事失败","");
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","网络异常",e.getMessage());
        }
        return jsonResult;
    }



}
