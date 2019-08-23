package org.taru.api.six;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.UserRelationVo;
import org.taru.service.six.ShareSixInterface;
import org.taru.service.six.ShareUpdatenterface;
import org.taru.vo.JsonResult;

import java.util.List;

@Controller
@CrossOrigin(allowCredentials = "true")
public class ShareSixApi {
    @Autowired
    ShareSixInterface s;

    /**
     * 根据当前用户id查好友id和名字
     * @return
     */
    @RequestMapping(value = "/api/ShareSixApi",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult searchOne(@Param("id")int id){
        List<UserRelationVo> list=s.shareSixDao(id);
        JsonResult json=null;
        try{
            if(list.size()>0){
                json=new JsonResult("200","查询成功",list);
            }else {
                json=new JsonResult("404","好友为空",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            json=new JsonResult("500","查询异常",null);
        }
        return json;
    }
    @Autowired
    ShareUpdatenterface update;
    /**
     * 根据好友id和当前房源id跟新消息表
     */
    @RequestMapping(value = "/api/searchUpdateApi",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult searchUpdate(@Param("relationId")int relationId,@Param("homeId")int homeId){
       int i= update.shareDao(relationId,homeId);
        JsonResult json=null;
        try{
            if(i!=0){
                json=new JsonResult("200","添加成功",null);
            }else {
                json=new JsonResult("404","添加失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            json=new JsonResult("500","添加异常",e.getMessage());
        }
        return json;

    }
}
