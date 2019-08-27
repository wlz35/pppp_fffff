package org.taru.api.four;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @ApiOperation(value="提交评论",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "discusstext", value = "评论的内容", required = true, paramType = "String"),
            @ApiImplicitParam(name = "homeid", value = "房屋id", required = true, paramType = "int"),
            @ApiImplicitParam(name = "userid", value = "用户id", required = true, paramType = "int")
    })
    @RequestMapping(value ="/api/insertdiscuss",method = RequestMethod.GET)//提交评论的接口
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
