package org.taru.api.four;

        import io.swagger.annotations.ApiImplicitParam;
        import io.swagger.annotations.ApiImplicitParams;
        import io.swagger.annotations.ApiOperation;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.redis.core.RedisTemplate;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;

        import org.taru.entity.Admin;
        import org.taru.entity.User;
        import org.taru.service.four.LoginService;
        import org.taru.util.SecurityUtl;
        import org.taru.vo.JsonResult;

        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.util.concurrent.TimeUnit;
        import java.util.logging.Logger;

@RestController
@CrossOrigin(allowCredentials = "true")
class LoginApi {
    //    private static final Logger logger = LoggerFactory.getLogger(LoginApi.class);
    @Autowired
    LoginService serviceImpl;

    @Autowired
    RedisTemplate redisTemplate;
    @ApiOperation(value="后台管理员的登录",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "String")

    })
    @RequestMapping(value = "/apih/adminlogin", method = RequestMethod.POST)
    @ResponseBody  //Ajax
    public JsonResult login(String name, String password, HttpServletResponse response) {
        JsonResult result = null;
        try {
            Admin user = serviceImpl.loginservice(name, password);
            if (user == null) {
                result = new JsonResult("404", "用户名或者密码错误", "");

            } else {
                String token_jSessionId = SecurityUtl.getMd5String(name); // 令牌
                redisTemplate.opsForHash().put("loginUserKey", token_jSessionId, user.getId());
                redisTemplate.opsForValue().set(token_jSessionId, user.getId());
                redisTemplate.expire(token_jSessionId, 24, TimeUnit.HOURS);
                //创建一个Cookie  存储令牌
                Cookie cookie = new Cookie("token", token_jSessionId);
                cookie.setPath("/");  //任何请求都要携带凭证
                cookie.setMaxAge(60 * 60 * 60);
                response.addCookie(cookie);
                result = new JsonResult("200", "ok", "");
//                logger.info("{}已经成功登陆,密码是{}",username,password);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
//            logger.error("登陆异常原因是[{}]",ex.getCause().getMessage());


        }
        return result;
    }

    /**
     * 退出的逻辑 :
     *
     * @return
     */
    @RequestMapping(value = "/apih/logout")   //Ajax
    @ResponseBody
    public JsonResult loginOut(HttpSession session) {

        JsonResult result = null;
        try {
            session.invalidate();   //Session销毁 清除登陆状态
            result = new JsonResult("200", "退出成功", "");
        } catch (Exception ex) {
            ex.printStackTrace();
            result = new JsonResult("500", "error", "");
        }
        return result;
    }
}
