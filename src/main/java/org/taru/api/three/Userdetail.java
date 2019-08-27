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


    @ApiOperation(value="根据用户ID查询用户详情",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "int"),

    })
    @RequestMapping(value = "/api/queryuser",method = RequestMethod.GET)
    @CrossOrigin
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
