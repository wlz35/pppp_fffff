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
import org.taru.entity.DIscussHomeVo;
import org.taru.service.six.DiscussOneQuaryInterface;
import org.taru.vo.JsonResult;

import java.util.List;

@Controller
@CrossOrigin(allowCredentials = "true")
public class DiscussQuaryOneApi {
    @Autowired
    DiscussOneQuaryInterface d;

    /**
     * 根据房屋id查询房屋评价
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */

    @RequestMapping(value = "/api/discussOneQuary",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult discussQuary(@Param("id")int id,@Param("pageNum")int pageNum, @Param("pageSize")int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<DIscussHomeVo> list=d.discussOneQuaryInterface(id);
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
            json=new JsonResult("500","查询异常",e.getMessage());
        }
        return json;
    }

}
