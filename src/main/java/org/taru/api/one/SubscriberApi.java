package org.taru.api.one;

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
     * 根据用户名密码查询用户详情
     * @param userName
     * @libing
     */
    @RequestMapping(value = "/api/user/queryByUandP",method = RequestMethod.GET)
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
    @RequestMapping(value = "/api/user/queryById",method = RequestMethod.GET)
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
    @RequestMapping(value = "/api/user/queryUser",method = RequestMethod.GET)
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
    @RequestMapping(value = "/api/user/deleteUser",method = RequestMethod.GET)
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
    @RequestMapping(value = "/api/user/updateUser",method = RequestMethod.GET)
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
