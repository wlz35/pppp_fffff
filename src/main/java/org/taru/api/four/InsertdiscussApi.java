package org.taru.api.four;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.service.four.InsertdiscussService;
import org.taru.vo.JsonResult;

import javax.servlet.http.HttpSession;
/*
提交评论，对相应的房屋进行评论
 */

@Controller
@CrossOrigin
public class InsertdiscussApi {

    @Autowired
    InsertdiscussService inserdis;
    @RequestMapping("/api/insertdiscuss")//提交评论的接口
    @ResponseBody
    public JsonResult insertdiscuss(@RequestParam("discusstext") String discusstext,
                                    @RequestParam("homeid") int homeid,
                                    @RequestParam("userid") int userid, HttpSession session) {

        JsonResult result = null;
        try {
            int p = inserdis.insertdiscussservice(discusstext,homeid,userid);


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
