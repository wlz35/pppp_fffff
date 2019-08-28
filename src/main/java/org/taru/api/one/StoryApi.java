package org.taru.api.one;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    /**
     * 查询所有故事
     * @return
     */

    @ApiOperation(value = "查询所有故事，不需要参数")
    @ApiImplicitParams({})
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


    /**
     * 根据城市查询故事
     * @param storyCity
     * @return
     */
    @ApiOperation(value = "根据城市查询故事")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storyCity", value = "城市名", dataType = "String", paramType = "query",
                    allowableValues = "北京,成都,重庆", allowMultiple = true)
    })
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

    /**
     * 根据故事ID查询故事详情
     * @param storyId
     * @return
     */
    @ApiOperation(value = "根据故事ID查询故事详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storyId", value = "城市ID", dataType = "String", paramType = "query",
                    allowableValues = "1,2,3", allowMultiple = true)
    })
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
