package org.taru.api.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.Story;
import org.taru.service.three.HotcityService;
import org.taru.vo.JsonResult;

import java.util.List;

@Controller
public class Hotcity {
    @Autowired
    HotcityService city;
    @CrossOrigin
    @RequestMapping("/api/hotcity")
    @ResponseBody
    public JsonResult queryPri(){
        JsonResult jsonclass = null;
        try {
            List<Story> hotcity = city.hotstorycity();
            if(hotcity==null){
                jsonclass = new JsonResult("400","查询失败","");
            }else{
                jsonclass = new JsonResult("200","查询成功",hotcity);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonclass = new JsonResult("500","error",e.getMessage());
        }

        return jsonclass;
    }
}
