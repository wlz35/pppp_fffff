package org.taru.api.four;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.service.four.GuanzhuService;
import org.taru.vo.JsonResult;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class GuanzhuApi {

    @Autowired
    GuanzhuService gs;
    @RequestMapping("/api/guanzhuapi")//提交评论的接口
    @ResponseBody
    public JsonResult guanzhuapi(
                                    @RequestParam("userid") int userid,
                                    @RequestParam("goodfriendid") int goodfriendid, HttpSession session) {

        JsonResult result = null;
        try {
            int p = gs.insertdiscussservice(userid,goodfriendid);


            if (p == 0) {
                result = new JsonResult("404", "评论失败", "gdf");
            } else {
                result = new JsonResult("200", "评论成功",p);
                session.setAttribute("selectsuccess",p);

            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "异常", "jfs");
        }
        return result;
    }
}
