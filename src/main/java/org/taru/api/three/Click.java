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
import org.taru.service.three.ClickService;
import org.taru.vo.JsonResult;

@Controller
public class Click {
    @Autowired
    ClickService city;



    @ApiOperation(value="故事点赞",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storyId",value = "故事ID", required = true, paramType = "int")
    })
    @RequestMapping(value = "/api/click",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public JsonResult queryPri(int storyId){
        JsonResult jsonclass = null;
        try {
            int hotcity = city.clik(storyId);
            if(hotcity==0){
                jsonclass = new JsonResult("400","点赞失败","");
            }else{
                jsonclass = new JsonResult("200","点赞成功",hotcity);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonclass = new JsonResult("500","error",e.getMessage());
        }

        return jsonclass;
    }
}
