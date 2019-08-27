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
import org.taru.service.three.HistoryorderService;
import org.taru.vo.JsonResult;

/**
 * 查询单个用户的历史订单
 */
@Controller
public class History {
    @Autowired
    HistoryorderService history;


    @ApiOperation(value="查询单个用户的历史订单",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType = "int")
    })
    @RequestMapping(value = "/api/queryhistory",method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public JsonResult queryPri(int userId){
        JsonResult jsonclass = null;
        try {
            User user = history.historyorder(userId);
            if(user==null){
                jsonclass = new JsonResult("400","查询失败","");
            }else{
                jsonclass = new JsonResult("200","查询成功",user);
            }

        }catch (Exception e){
            e.printStackTrace();
            jsonclass = new JsonResult("500","error",e.getMessage());
        }

        return jsonclass;
    }
}
