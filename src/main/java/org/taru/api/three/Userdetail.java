package org.taru.api.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.User;
import org.taru.service.three.UserdetailService;
import org.taru.vo.JsonResult;

/**
 * 根据用户ID查询用户详情
 */
@Controller
public class Userdetail {
    @Autowired
    UserdetailService detail;
    @CrossOrigin
    @RequestMapping("/api/queryuser")
    @ResponseBody
    public JsonResult queryPri(int userId){
        JsonResult jsonclass = null;
        try {
            User user = detail.userdetail(userId);
            if(user==null){
                jsonclass = new JsonResult("400","查询用户失败","");
            }else{
                jsonclass = new JsonResult("200","查询详情成功",user);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonclass = new JsonResult("500","error","");
        }

        return jsonclass;
    }
}
