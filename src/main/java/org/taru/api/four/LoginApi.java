package org.taru.api.four;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.taru.entity.Admin;
import org.taru.service.four.LoginService;
import org.taru.vo.JsonResult;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
class LoginApi {
    @Autowired
    LoginService ls;
    @RequestMapping("/api/adminlogin")//后台管理员登录接口
    @ResponseBody
    public JsonResult adminLogin(@RequestParam("name") String name,
                                @RequestParam("password") String password, HttpSession session) {
        Admin user =new Admin();
        user.setName(name);
        user.setPassword(password);
        JsonResult result = null;
        Admin users=null;
        try {
            users= ls.loginservice(user);
            if (users == null) {
                result = new JsonResult("404", "登录失败", null);
            } else {
                result = new JsonResult("200", "登录成功",users );
                session.setAttribute("loginUserKey", users);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "登录异常", e.getMessage());
        }
        System.out.println(result.toString());
        return result;
    }
}
