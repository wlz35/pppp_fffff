package org.taru.api.one;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.taru.entity.User;
import org.taru.service.one.UserService;
import org.taru.util.AliyunSmsUtils;
import org.taru.vo.JsonResult;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;



@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
@RestController
public class UserApi {
    @Autowired
    UserService service;
    @Autowired
    RedisTemplate redisTemplate;
    @Value("F:\\images")
    private String uploadAbsolutePath;

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @libing
     */
    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", paramType = "query",
                    allowableValues = "李冰冰,王洛雪", allowMultiple = true),
            @ApiImplicitParam(name = "passWord", value = "用户密码", dataType = "String", paramType = "query",
                    allowableValues = "123456", allowMultiple = true)
    })
    @RequestMapping(value = "/api/login",method = RequestMethod.GET)
    public JsonResult login(String userName, String passWord, HttpServletRequest request, HttpServletResponse response){
        JsonResult jsonResult = null;
        try{
            User user = service.login(userName, passWord);
            //String cookidId = String.valueOf(user.getUserId());
            if(user!=null){
//                Cookie cookie= new Cookie("token",cookidId);
//                cookie.setMaxAge(60*60*60);
//                response.addCookie(cookie);
                request.getSession().setAttribute("loginKey",user);
                jsonResult=new JsonResult("200","登录成功",user);
            }else{
                jsonResult=new JsonResult("404","账号或密码错误","");
            }
        }
        catch (Exception e){
            jsonResult = new JsonResult("500","网络异常",e.getMessage());
        }
        return jsonResult;
    }


    /**
     * 退出的逻辑
     * @return
     */
    @ApiOperation(value = "用户退出,无参数")
    @ApiImplicitParams({})
    @RequestMapping(value = "/api/logout",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult loginOut(HttpServletResponse response) {
        JsonResult  result=null;
        try{
            Cookie cookie2 = new Cookie("JSESSIONID",null);
            cookie2.setPath("/");
            cookie2.setValue(null);
            cookie2.setMaxAge(0);
            response.addCookie(cookie2);

            result  =new JsonResult("200","退出成功","");
        }catch (Exception  ex){
            ex.printStackTrace();
            result  =new JsonResult("500","error","");
        }
        return result;
    }


    /**
     * 用户注册
     * @param user
     * @libing
     */
    @ApiOperation(value = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", paramType = "query",
                    allowableValues = "小黑,小白", allowMultiple = true),
            @ApiImplicitParam(name = "passWord", value = "用户密码", dataType = "String", paramType = "query",
                    allowableValues = "666666,888888", allowMultiple = true),
            @ApiImplicitParam(name = "sex", value = "性别", dataType = "String", paramType = "query",
                    allowableValues = "男,女", allowMultiple = true),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String", paramType = "query",
                    allowableValues = "182@qq.com,135@163.com", allowMultiple = true),
            @ApiImplicitParam(name = "phone", value = "电话", dataType = "String", paramType = "query",
                    allowableValues = "15866666666,13588888888", allowMultiple = true),
            @ApiImplicitParam(name = "userHeaderPicture", value = "用户头像", dataType = "String", paramType = "query",
                    allowableValues = "1.jpg,2.jpg", allowMultiple = true)
    })
    @RequestMapping(value = "/api/user/regiser",method = RequestMethod.POST)
    public JsonResult regiser(User user){
        JsonResult jsonResult = null;
        try{
            int row = service.resiger(user);
            if(user!=null){
                jsonResult=new JsonResult("200","注册成功",row);
            }else{
                jsonResult=new JsonResult("404","注册失败，请重新注册","");
            }
        }
        catch (Exception e){
            jsonResult = new JsonResult("500","网络异常",e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 短信验证码
     * 返回验证码
     */
    @ApiOperation(value = "接受短信验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telphone", value = "电话", dataType = "String", paramType = "query",
                    allowableValues = "15899315133,13569206257", allowMultiple = true),
    })
    @RequestMapping(value = "/api/resiger/sendCode",method = RequestMethod.GET)
    public JsonResult getCode(String telphone)throws ClientException {
        JsonResult jsonResult = null;
        try{
            AliyunSmsUtils.setNewcode();
            String code = Integer.toString(AliyunSmsUtils.getNewcode());
            SendSmsResponse phoneCode = AliyunSmsUtils.sendSms(telphone,code);
            if(phoneCode!=null){
                jsonResult = new JsonResult("200","发送成功",code);
            }else{
                jsonResult = new JsonResult("404","发送失败","");
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","网络错误","");
        }
        return jsonResult;
    }

    /**
     * 上传图片
     * 返回图片名字
     */

    @ApiOperation(value = "上传图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userHeaderPicture", value = "图片文件", dataType = "String", paramType = "query",
                    allowableValues = "选择本地文件", allowMultiple = true),
    })
    @RequestMapping(value = "/api/user/upload",method = RequestMethod.POST)
    public JsonResult updload(@RequestParam("userHeaderPicture") MultipartFile multipartFile){
        JsonResult jsonResult = null;
        if(!multipartFile.isEmpty()){
            try{
                multipartFile.transferTo(new File(uploadAbsolutePath +"\\"+ multipartFile.getOriginalFilename()));
                jsonResult = new JsonResult("200","上传成功",multipartFile.getOriginalFilename());
            }catch(Exception e){
                e.printStackTrace();
                jsonResult = new JsonResult("500","网络异常","");
            }
        }else{
            jsonResult = new JsonResult("404","上传失败","");
        }
        return jsonResult;
    }




}
