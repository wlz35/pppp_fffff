package org.taru.api.one;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.taru.entity.Home;
import org.taru.service.one.HomesService;
import org.taru.vo.JsonResult;
import java.util.List;

@CrossOrigin
@RestController
public class HomesApi {

    @Autowired
    HomesService service;

    /**
     * 根据城市/景点/时间查询房源/多条件查询/分页
     * 返回房源信息，房东信息，图片信息，评价信息
     * @param homeAddress
     * @param homeSpot
     * @libing
     */
    @ApiOperation(value = "根据用户名或电话查询用户详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "homeAddress", value = "房源地址", dataType = "String", paramType = "query",
                    allowableValues = "北京", allowMultiple = true),
            @ApiImplicitParam(name = "homeSpot", value = "附近景点", dataType = "String", paramType = "query",
                    allowableValues = "天安门", allowMultiple = true),
            @ApiImplicitParam(name = "homeInDate", value = "入住时间", dataType = "String", paramType = "query",
                    allowableValues = "2019-08-06", allowMultiple = true),
            @ApiImplicitParam(name = "homeOutDate", value = "离开时间", dataType = "String", paramType = "query",
                    allowableValues = "2019-08-31", allowMultiple = true),
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int", paramType = "query",
                    allowableValues = "1", allowMultiple = true),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", dataType = "int", paramType = "query",
                    allowableValues = "4", allowMultiple = true),
    })
    @RequestMapping(value = "/api/home/queryByAddressAndSpot",method = RequestMethod.GET)
    public JsonResult queryByAddressAndSpot(String homeAddress, String homeSpot, String homeInDate, String homeOutDate,int pageNum, int pageSize){
        JsonResult jsonResult = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Home> homes = service.queryByAandS(homeAddress,homeSpot,homeInDate,homeOutDate);
            PageInfo pageInfo = new PageInfo(homes);
            if(homes!=null){
                jsonResult = new JsonResult("200","查询成功",pageInfo);
            }else{
                jsonResult = new JsonResult("404","查询失败","");
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","网络异常",e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 根据风格查询房源信息/按点赞数降序排列/分页
     * @param styleName
     * @libing
     */
    @ApiOperation(value = "根据风格查询房源信息/按点赞数降序排列/分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "styleName", value = "风格名称", dataType = "String", paramType = "query",
                    allowableValues = "美式风格", allowMultiple = true),
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int", paramType = "query",
                    allowableValues = "1", allowMultiple = true),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", dataType = "int", paramType = "query",
                    allowableValues = "4", allowMultiple = true),
    })
    @RequestMapping(value = "/api/home/queryByStyle",method = RequestMethod.GET)
    public JsonResult queryByStyle(String styleName,int pageNum,int pageSize){
        JsonResult jsonResult = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Home> homes = service.queryByStyle(styleName);
            PageInfo pageInfo = new PageInfo(homes);
            if(homes!=null){
                jsonResult = new JsonResult("200","查询成功",pageInfo);
            }else{
                jsonResult = new JsonResult("404","查询失败","");
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","网络异常","");
        }
        return jsonResult;
    }

    /**
     * 根据城市查询/点赞降序/分页
     * 返回所有房源信息
     */
    @ApiOperation(value = "根据城市查询/点赞降序/分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "homeAddress", value = "房源地址", dataType = "String", paramType = "query",
                    allowableValues = "北京", allowMultiple = true),
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int", paramType = "query",
                    allowableValues = "1", allowMultiple = true),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", dataType = "int", paramType = "query",
                    allowableValues = "4", allowMultiple = true),
    })
    @RequestMapping(value = "/api/home/queryByCity",method = RequestMethod.GET)
    public JsonResult queryByCity(String homeAddress,int pageNum,int pageSize){
        JsonResult jsonResult = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List<Home> homes = service.queryByCity(homeAddress);
            PageInfo pageInfo = new PageInfo(homes);
            if(homes!=null){
                jsonResult = new JsonResult("200","查询成功",pageInfo);
            }else{
                jsonResult = new JsonResult("404","查询失败","");
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","网络异常","");
        }
        return jsonResult;
    }


}
