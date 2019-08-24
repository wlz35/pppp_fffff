package org.taru.api.five;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.service.five.InformationService;
import org.taru.vo.JsonResult;

import java.util.List;

/**
 * 根据用户ID查消息
 */

@Controller
public class InformationApi {

    @Autowired
    InformationService impl;

    @CrossOrigin
    @RequestMapping("/api/queryinfor")
    @ResponseBody
    public JsonResult queryInformationApi(int userId){
        JsonResult jsonResult = null;
        try {
            List list  = impl.queryInforByUserIdService(userId);
            if(list==null){
                jsonResult = new JsonResult("500","查询异常","");
            }else{
                jsonResult = new JsonResult("200","查询成功",list);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","error","");
        }
        return jsonResult;

    }
}
