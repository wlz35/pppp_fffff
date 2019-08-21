package org.taru.api.six;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.entity.HomeLandlordStyleVO;
import org.taru.service.six.SearchTwoInterface;
import org.taru.vo.JsonResult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@CrossOrigin(allowCredentials = "true")
public class SearchTwoApi {
    @Autowired
    SearchTwoInterface d;
    @RequestMapping(value = "/api/searchTwo",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult searchTwo(@Param("homeInDate")Date homeInDate,
                                @Param("homeOutDate")Date homeOutDate,
                                @Param("styleName")String styleName,
                                @Param("homeAddress")String homeAddress,
                                @Param("homeSpot")String homeSpot,
                                @Param("pageNum")int pageNum,
                                @Param("pageSize")int pageSize){
        HashMap hashMap=new HashMap();
        hashMap.put("homeInDate",homeInDate);
        hashMap.put("homeOutDate",homeOutDate);
        hashMap.put("styleName",styleName);
        hashMap.put("homeAddress",homeAddress);
        hashMap.put("homeSpot",homeSpot);
        PageHelper.startPage(pageNum,pageSize);
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
