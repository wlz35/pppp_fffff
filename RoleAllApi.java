package api;


import entity.Allentity;
import entity.Role;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import vo.JsonResult;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 查询所有的角色，并且显示所有的角色信息
 */
@Controller
public class RoleAllApi {
    @RequestMapping("/api/Roleall")
    @ResponseBody
    public JsonResult selectall(HttpSession session) {
        UserService us = new UserService();
        JsonResult result = null;
        try {
            List<Allentity> role = us.userservice();

            if (role == null) {
                result = new JsonResult("404", "查询失败", "gdf");
            } else {
                result = new JsonResult("200", "查询成功", role);
                 session.setAttribute("selectsuccess",role);

            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "异常", "jfs");
        }
        return result;
    }
}
