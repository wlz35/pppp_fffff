package org.taru.api.six;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.taru.entity.HomeLandlordStyleVO;
import org.taru.service.six.SearchTwoInterface;
import org.taru.vo.JsonResult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@CrossOrigin(allowCredentials = "true")
public class SearchTwoApi {
    @Autowired
    SearchTwoInterface d;
    @RequestMapping(value = "/api/searchTwo",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult searchTwo(@RequestBody Map<String,Object> map){
//        @Param("homeInDate")Date homeInDate,
//        @Param("homeOutDate")Date homeOutDate,
//        @Param("styleName")String styleName,
//        @Param("homeAddress")String homeAddress,
//        @Param("homeSpot")String homeSpot,
//        @Param("pageNum")int pageNum,
//        @Param("pageSize")int pageSize

        HashMap hashMap=new HashMap();
        hashMap.put("homeInDate",map.get("homeInDate"));
        hashMap.put("homeOutDate",map.get("homeOutDate"));
        hashMap.put("styleName",map.get("styleName"));
        hashMap.put("homeAddress",map.get("homeAddress"));
        hashMap.put("homeSpot",map.get("homeSpot"));
        PageHelper.startPage((int)map.get("pageNum"),(int)map.get("pageSize"));
        List<HomeLandlordStyleVO> list=d.searchTwoDao(hashMap);
        PageInfo pageInfo=new PageInfo(list);
        JsonResult json=null;
        try{
            if(list.size()>0){
                json=new JsonResult("200","查询成功",pageInfo);
            }else {
                json=new JsonResult("404","查询失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            json=new JsonResult("500","查询异常",null);
        }
        return json;


    }
}
