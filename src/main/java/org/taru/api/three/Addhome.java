package org.taru.api.three;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @ApiOperation(value="房东发布房源信息",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "styleName", value = "风格名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeName", value = "房源名", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeAddress", value = "房源地址", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homePrice", value = "房源价格", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeInDate",value = "用户入住时间", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeOutDate",value = "用户退房时间", required = true, paramType = "String"),
            @ApiImplicitParam(name = "pictureOne",value = "图片1", required = true, paramType = "String"),
            @ApiImplicitParam(name = "pictureTwo",value = "图片2", required = true, paramType = "String"),
            @ApiImplicitParam(name = "pictureThree",value = "图片3", required = true, paramType = "String"),
            @ApiImplicitParam(name = "pictureFour",value = "图片4", required = true, paramType = "String"),
            @ApiImplicitParam(name = "pictureFive",value = "图片5", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeDescribe",value = "房源描述", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeSpot",value = "房源靠近的景点", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeConfigure",value = "房源配置", required = true, paramType = "String"),
            @ApiImplicitParam(name = "landlordPhone",value = "房东电话", required = true, paramType = "String"),
    })
    @RequestMapping(value = "/api/addhome",method = RequestMethod.POST)

    @CrossOrigin
    @ResponseBody
    public JsonResult queryPri(String styleName,String homeName,String homeAddress
            ,String homePrice,String homeInDate,String homeOutDate,String pictureOne,String pictureTwo,String pictureThree,String pictureFour,String pictureFive,String homeDescribe,String homeSpot,String homeConfigure,
                               String landlordPhone){
        JsonResult jsonclass = null;
        int h=home.addhome(styleName,homeName,homeAddress
                ,homePrice,homeInDate,homeOutDate,pictureOne,pictureTwo,pictureThree,pictureFour,pictureFive,homeDescribe,homeSpot,homeConfigure,
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
