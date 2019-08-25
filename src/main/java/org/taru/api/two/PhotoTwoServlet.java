package org.taru.api.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.service.two.PhotoTwoService;
import org.taru.vo.JsonResult;
import org.taru.vo.two.Pictures;


@RestController
public class PhotoTwoServlet {
    @Autowired
    PhotoTwoService photoTwoService;
    /**
     * 上传图片
     */
    @RequestMapping("/api/upload/photo")
    public JsonResult photoUpload2(Pictures pictures){
        JsonResult jsonResult = null;
        try{
            int pic = photoTwoService.photoUpload1(pictures);
            if (pic!=0){
                jsonResult = new JsonResult("200","success",pic);
            }else {
                jsonResult = new JsonResult("400", "fail", null);
            }
        }catch (Exception e){
            jsonResult = new JsonResult("500", "服务器异常", e.getMessage());
        }
        return jsonResult;
    }

}
