package org.taru.api.six;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.taru.entity.DateHomeVo;
import org.taru.entity.Home;
import org.taru.entity.HomeLandlordStyleVO;
import org.taru.entity.Style;
import org.taru.service.six.AdressQuaryInterface;
import org.taru.service.six.SearchTwoInterface;
import org.taru.service.six.StyleServiceInterface;
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

    /**
     * 多条件查询 根据前端发送json 数据为Map 传homeInDate、homeOutDate、styleName、homeAddress、homeSpot、pageNum、pageSize
     * 查询房东信息、房源信息、房源图片
     * @param
     * @return
     */

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/searchTwo",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult searchTwo(@Param("homeInDate")String homeInDate,
                                        @Param("homeOutDate")String homeOutDate,
                                        @Param("styleName")String styleName,
                                        @Param("homeAddress")String homeAddress,
                                        @Param("closingPrice")String closingPrice,
                                        @Param("beginningPrice")String beginningPrice,
                                        @Param("pageNum")int pageNum,
                                        @Param("pageSize")int pageSize){
        System.out.println(homeInDate+homeOutDate+styleName+homeAddress+closingPrice+beginningPrice+pageNum+pageSize);


        HashMap hashMap=new HashMap();
        hashMap.put("homeInDate",homeInDate);
        hashMap.put("homeOutDate",homeOutDate);
        hashMap.put("styleName",styleName);
        hashMap.put("homeAddress",homeAddress);
        hashMap.put("closingPrice",closingPrice);
        hashMap.put("beginningPrice",beginningPrice);
            System.out.println(hashMap);
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
    @Autowired
    StyleServiceInterface s;
    /**
     * 查询所有风格
     *
     * @return
     */
    @RequestMapping(value = "/api/style",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult style(){
        List<Style> list=s.stylesDao();
        JsonResult json=null;
        try{
            if(list.size()>0){
                json=new JsonResult("200","查询成功",list);
            }else {
                json=new JsonResult("404","查询失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            json=new JsonResult("500","查询异常",null);
        }
        return json;
    }
    @Autowired
    AdressQuaryInterface a;
    /**
     * 查询城市
     *
     * @return
     */
    @RequestMapping(value = "/api/addressSix",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult address(){
        List<Home> list=a.addressService();
        JsonResult json=null;
        try{
            if(list.size()>0){
                json=new JsonResult("200","查询成功",list);
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
