package org.taru.api.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.service.two.QueryHomeDiscussService;
import org.taru.vo.JsonResult;
import org.taru.vo.two.Home;

import java.util.List;

@RestController
public class QueryHomeDiscussServlet {
    @Autowired
    QueryHomeDiscussService queryHomeDiscussService;

    /**
     * 根据房源 查询用户多条评论（关联HOME LANDLORD DISCUSS）
     * @param homeId
     * @return
     */
    @RequestMapping("/api/user/queryHomeDiscuss")
    public JsonResult queryHomeDiscuss2(String homeId){
        JsonResult jsonResult = null;
        try{
            List<Home> home = queryHomeDiscussService.queryHomeDiscuss1(homeId);
            if(home!=null){
                jsonResult = new JsonResult("200","queryHomeDiscuss Success",home);
            }else {
                jsonResult = new JsonResult("400","queryHomeDiscuss Fail",null);
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500","exception",e.getMessage());
        }
        return jsonResult;
    }
}
