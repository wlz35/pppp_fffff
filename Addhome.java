package org.taru.api.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.service.three.AddhomeService;
import org.taru.vo.JsonResult;

/**
 * 房东发布房源信息
 */
@Controller
public class Addhome {
    @Autowired
    AddhomeService home;
    @CrossOrigin
    @RequestMapping("/api/addhome")
    @ResponseBody
    public JsonResult queryPri(String styleName,String homeName,String homeAddress
            ,String homePrice,String home_in_Date,String home_out_Date,String picturesId,String homeDescribe,String homeSpot,String homeConfigure,
                               String landlordPhone){
        JsonResult jsonclass = null;
        int h =home.addhome(styleName,homeName,homeAddress,homePrice,home_in_Date,home_out_Date,picturesId,homeDescribe,homeSpot,homeConfigure,
                landlordPhone);
        try {
            if(h==0){
                jsonclass = new JsonResult("400","添加房源信息失败","");
            }else{
                jsonclass = new JsonResult("200","添加房源信息成功",h);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonclass = new JsonResult("500","error",e.getMessage());
        }

        return jsonclass;
    }
}
