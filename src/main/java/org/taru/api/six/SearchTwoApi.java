package org.taru.api.six;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
     * @param dateHomeVo
     * @return
     */
    @ApiOperation(value="多条件查询房东信息，房源信息，房源图片方法",notes="注意参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "homeInDate", defaultValue = "1", value = "房屋开始时间", required = false, paramType = "String"),
            @ApiImplicitParam(name = "homeOutDate", defaultValue = "1", value = "房屋结束时间", required = false, paramType = "String"),
            @ApiImplicitParam(name = "styleName", defaultValue = "1", value = "房屋风格", required = false, paramType = "String"),
            @ApiImplicitParam(name = "homeAddress", defaultValue = "1", value = "城市名字", required = false, paramType = "String"),
            @ApiImplicitParam(name = "beginningPrice", defaultValue = "1", value = "起始价格", required = false, paramType = "String"),
            @ApiImplicitParam(name = "closingPrice", defaultValue = "1", value = "最后价格", required = false, paramType = "String"),
            @ApiImplicitParam(name = "pageNum", defaultValue = "1", value = "当前页", required = true, paramType = "int"),
            @ApiImplicitParam(name = "pageSize", defaultValue = "1", value = "每页条数", required = true, paramType = "int")
    })
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
    @ApiOperation(value="查询所有风格方法",notes="注意参数")
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
    @ApiOperation(value="查询所有风格方法",notes="注意参数")
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
