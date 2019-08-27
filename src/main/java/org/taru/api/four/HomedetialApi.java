package org.taru.api.four;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.taru.entity.Home;
import org.taru.service.four.HomeService;
import org.taru.vo.JsonResult;

import javax.servlet.http.HttpSession;
//后台查看房屋的详细信息
@RestController
@CrossOrigin(allowCredentials = "true")
public class HomedetialApi {

    @Autowired
    HomeService detial;
    @ApiOperation(value="查看房屋的详细信息",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "homeid", value = "房屋的id", required = true, paramType = "int"),

    })
    @RequestMapping(value = "/apih/homedetial",method = RequestMethod.GET)//提交评论的接口
    public JsonResult guanzhuapi(
            @RequestParam("homeid") int homeid,
              HttpSession session) {

        JsonResult result = null;
        try {
            Home p = detial.Homedetail(homeid);
            if (p == null) {
                result = new JsonResult("404", "查询详情失败", "");
            } else {
                result = new JsonResult("200", "查询详情成功",p);
//                session.setAttribute("selectsuccess",p);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new JsonResult("500", "异常", e.getMessage());
        }
        return result;
    }
}
