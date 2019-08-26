package org.taru.api.six;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.taru.service.six.DisscussDeleteInterface;
import org.taru.vo.JsonResult;

import java.util.List;

@Controller
@CrossOrigin(allowCredentials = "true")
public class DiscussDeleteApi {
    @Autowired
    DisscussDeleteInterface d;

    /**
     * 删除评论
     * @param id
     * @param
     * @return
     */
    @ApiOperation(value="删除评论方法",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", defaultValue = "1", value = "评论ID", required = true, paramType = "int"),
    })
    @RequestMapping(value = "/apih/discussDelete",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult discussQuary(@Param("id")int id){
        int i=d.discussDeleteInterface(id);
        JsonResult json=null;
        try{
            if(i!=0){
                json=new JsonResult("200","删除成功",null);
            }else {
                json=new JsonResult("404","删除失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            json=new JsonResult("500","删除异常",e.getMessage());
        }
        return json;
    }
}
