package org.taru.api.one;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.taru.entity.User;
import org.taru.service.one.UserService;
import org.taru.util.AliyunSmsUtils;
import org.taru.vo.JsonResult;
import java.io.File;

@Controller
@RestController
public class UserApi {
    @Autowired
    UserService service;
    @Value("F:\\images")
    private String uploadAbsolutePath;

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @libing
     */
    @RequestMapping(value = "/api/login",method = RequestMethod.GET)
    public JsonResult login(String userName,String passWord){
        JsonResult jsonResult = null;
        try{
            User user = service.login(userName, passWord);
            if(user!=null){
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
     * 用户注册
     * @param user
     * @libing
     */
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
     */
    @RequestMapping("/api/user/upload")
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
