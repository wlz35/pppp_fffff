package org.taru.api.two;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.taru.service.two.HomeService;
import org.taru.vo.JsonResult;

import java.util.List;

@RestController
@CrossOrigin
public class HomeServlet {
    @Autowired
    HomeService homeService;
    /**
     *查询房源详细信息（包括房东、评论、配置）
     * @return
     */
    @ApiOperation(value = "查询房源详细信息（包括房东、评论、配置）")
    @RequestMapping(value = "/api/user/queryAllHomeInfo",method = RequestMethod.GET)
    public JsonResult queryHomeInfo2() {
        JsonResult jsonResult = null;
        try {
            List home = homeService.queryHomeInfo1();
            if (home != null) {
                jsonResult = new JsonResult("200", "查询房源详细信息（包括房东、评论、配置）成功", home);
            } else {
                jsonResult = new JsonResult("400", "查询房源详细信息（包括房东、评论、配置）失败", null);
            }
        } catch (Exception e) {
            jsonResult = new JsonResult("500", "", e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 查询所有房源风格
     * @return
     */
    @ApiOperation(value = "查询所有房源风格")
    @RequestMapping(value = "/api/user/queryHomeStyle",method = RequestMethod.GET)
    public JsonResult queryHomeStyle2(){
        JsonResult jsonResult = null;
        try {
            List home = homeService.queryHomeStyle1();
            if (home != null) {
                jsonResult = new JsonResult("200", "查询房源风格成功", home);
            } else {
                jsonResult = new JsonResult("400", "查询房源风格失败", null);
            }
        } catch (Exception e) {
            jsonResult = new JsonResult("500", "", e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 根据ID查询房源详细信息
     * @param homeId
     * @return
     */
    @ApiOperation(value = "根据ID查询房源详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "home", defaultValue = "1", value = "homeId", required = true, paramType = "String"),
    })
    @RequestMapping(value = "/api/user/queryHomeInfoById",method = RequestMethod.GET)
    public JsonResult queryHomeInfoById2(String homeId){
        JsonResult jsonResult = null;
        try{
            List home = homeService.queryHomeInfoById1(homeId);
            if(home != null){
                jsonResult = new JsonResult("200","根据ID查询房源详细信息成功",home);
            }else {
                jsonResult = new JsonResult("400","根据ID查询房源详细信息失败",null);
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","服务器异常",e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 根据房源ID房源图片（5张），房东信息，房东头像，评论信息
     * @param homeId
     * @return
     */
    @ApiOperation(value = "根据房源ID房源图片（5张），房东信息，房东头像，评论信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "home", defaultValue = "1", value = "homeId", required = true, paramType = "String"),
    })
    @RequestMapping(value = "/api/user/query/HomeById", method = RequestMethod.GET)
    public JsonResult queryHomeById2(String homeId){
        JsonResult jsonResult = null;
        try{
            List home = homeService.queryHomeById1(homeId);
            if(home != null){
                jsonResult = new JsonResult("200","根据房源ID房源图片（5张），房东信息，房东头像，评论信息成功",home);
            }else {
                jsonResult = new JsonResult("400","根据房源ID房源图片（5张），房东信息，房东头像，评论信息失败",null);
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","服务器异常",e.getMessage());
        }
        return jsonResult;
    }

}
