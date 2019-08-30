
package org.taru.api.one;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.taru.entity.User;

import org.taru.service.one.SubscriberService;
import org.taru.vo.JsonResult;
import java.util.List;

@CrossOrigin
@RestController
public class SubscriberApi {

    @Autowired
    SubscriberService service;
    /**
     * 根据用户名或电话查询用户详情
     * @param userName
     * @libing
     */
    @ApiOperation(value = "根据用户名或电话查询用户详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", paramType = "query",
                    allowableValues = "李冰冰,王洛雪", allowMultiple = true),
            @ApiImplicitParam(name = "telphone", value = "用户电话", dataType = "String", paramType = "query",
                    allowableValues = "123456789", allowMultiple = true)
    })
    @RequestMapping(value = "/apih/user/queryByUandP",method = RequestMethod.GET)
    public JsonResult queryByUandP(String userName, String telphone){
        JsonResult jsonResult = null;
        try{
            List<User> list = service.queryByUandP(userName, telphone);
            if(list!=null){
                jsonResult=new JsonResult("200","查询成功",list);
            }else{
                jsonResult=new JsonResult("404","查询失败","");
            }
        }
        catch (Exception e){
            jsonResult = new JsonResult("500","网络异常",e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 根据用户Id查询用户详情
     * @libing
     */
    @ApiOperation(value = "根据用户Id查询用户详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", paramType = "query",
                    allowableValues = "1,2,3", allowMultiple = true)
    })
    @RequestMapping(value = "/apih/user/queryById",method = RequestMethod.GET)
    public JsonResult queryById(String userId){
        JsonResult jsonResult = null;
        try{
            User user = service.queryById(userId);
            if(user!=null){
                jsonResult=new JsonResult("200","查询成功",user);
            }else{
                jsonResult=new JsonResult("404","查询失败","");
            }
        }
        catch (Exception e){
            jsonResult = new JsonResult("500","网络异常",e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 查询所有用户
     * @libing
     */
    @ApiOperation(value = "查询所有用户,不需要参数")
    @ApiImplicitParams({})
    @RequestMapping(value = "/apih/user/queryUser",method = RequestMethod.GET)
    public JsonResult queryUser(){
        JsonResult jsonResult = null;
        try{
            List<User> list = service.queryUser();
            if(list!=null){
                jsonResult=new JsonResult("200","查询成功",list);
            }else{
                jsonResult=new JsonResult("404","查询失败","");
            }
        }
        catch (Exception e){
            jsonResult = new JsonResult("500","网络异常",e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 逻辑删除用户
     * @libing
     */
    @ApiOperation(value = "逻辑删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", paramType = "query",
                    allowableValues = "1,2,3", allowMultiple = true)
    })
    @RequestMapping(value = "/apih/user/deleteUser",method = RequestMethod.GET)
    public JsonResult deleteUser(String userId){
        JsonResult jsonResult = null;
        try{
            int row = service.deleteUser(userId);
            if(row>0){
                jsonResult=new JsonResult("200","删除成功",row);
            }else{
                jsonResult=new JsonResult("404","删除失败","");
            }
        }
        catch (Exception e){
            jsonResult = new JsonResult("500","网络异常",e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 修改用户名密码
     * @param userName
     * @param passWord
     * @libing
     */
    @ApiOperation(value = "修改用户名密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", paramType = "query",
                    allowableValues = "李一,王二", allowMultiple = true),
            @ApiImplicitParam(name = "passWord", value = "用户密码", dataType = "String", paramType = "query",
                    allowableValues = "12345678", allowMultiple = true),
            @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "String", paramType = "query",
                    allowableValues = "1,2,3", allowMultiple = true)
    })
    @RequestMapping(value = "/apih/user/updateUser",method = RequestMethod.GET)
    public JsonResult updateUser(String userName, String passWord,String userId){
        JsonResult jsonResult = null;
        try{
            int row = service.updateUser(userName, passWord,userId);
            if(row>0){
                jsonResult=new JsonResult("200","修改成功",row);
            }else{
                jsonResult=new JsonResult("404","修改失败","");
            }
        }
        catch (Exception e){
            jsonResult = new JsonResult("500","网络异常",e.getMessage());
        }
        return jsonResult;
    }
}
