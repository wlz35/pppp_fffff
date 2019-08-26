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


    @ApiOperation(value="查询风格（style）的所有信息",notes="无参数")
    @RequestMapping(value = "/apih/queryallstyle",method = RequestMethod.GET)
    @CrossOrigin
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


    @ApiOperation(value="添加风格（style）",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "styleId", defaultValue = "1", value = "风格ID", required = true, paramType = "int"),
            @ApiImplicitParam(name = "styleName", defaultValue = "1", value = "风格名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "styleStatus", defaultValue = "1", value = "风格状态", required = true, paramType = "int")
    })
    @RequestMapping(value = "/apih/addstyle",method = RequestMethod.GET)
    @CrossOrigin
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

    @ApiOperation(value="根据ID修改风格",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "styleId", defaultValue = "1", value = "风格ID", required = true, paramType = "int"),
            @ApiImplicitParam(name = "styleName", defaultValue = "1", value = "风格名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "styleStatus", defaultValue = "1", value = "风格状态", required = true, paramType = "int"),
    })
    @RequestMapping(value = "/apih/updatestyle",method = RequestMethod.GET)
    @CrossOrigin
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

    @ApiOperation(value="根据ID逻辑删除风格",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "styleId",value = "风格ID", required = true, paramType = "int")
    })
    @RequestMapping(value = "/apih/deletestyle",method = RequestMethod.GET)
    @CrossOrigin
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
