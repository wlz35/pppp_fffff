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
import org.taru.entity.HomeCollection;
import org.taru.entity.UserRelationVo;
import org.taru.service.six.CollectionInsertInterface;
import org.taru.service.six.CollectionQuaryInterface;
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
    @ApiOperation(value="查好友id和名字方法",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", defaultValue = "1", value = "当前用户ID", required = true, paramType = "int"),
    })
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
    @ApiOperation(value="根据好友id和当前房源id查询消息表方法",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "relationId", defaultValue = "1", value = "好友ID", required = true, paramType = "int"),
            @ApiImplicitParam(name = "homeId", defaultValue = "1", value = "当前房源ID", required = true, paramType = "int")
    })
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
    @Autowired
    CollectionQuaryInterface c;
    /**
     * 根据当前用户ID查收藏信息
     */
    @ApiOperation(value="根据当前用户ID查收藏信息方法",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", defaultValue = "1", value = "当前用户ID", required = true, paramType = "int"),
    })
    @RequestMapping(value = "/api/collectionQuarys",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult collectionQuarys(@Param("userId")int userId){
        List<HomeCollection> list2=c.collectionQuary(userId);
        JsonResult json=null;
        try{
            if(list2.size()>0){
                json=new JsonResult("200","查询成功",list2);
            }else {
                json=new JsonResult("404","查询失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            json=new JsonResult("500","查询异常",e.getMessage());
        }
        return json;

    }


@Autowired
    CollectionInsertInterface c1;
    /**
     * 根据当前用户ID 收藏 房源ID
     */
    @ApiOperation(value="根据当前用户ID 收藏 房源ID方法",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", defaultValue = "1", value = "当前用户ID", required = true, paramType = "int"),
            @ApiImplicitParam(name = "homeId", defaultValue = "1", value = "当前房源ID", required = true, paramType = "int")
    })
    @RequestMapping(value = "/api/collectionInsert",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult collectionInsert(int userId,int homeId){
        int i=c1.collectionInsert(userId,homeId);
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
