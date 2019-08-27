package org.taru.api.two;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.taru.service.two.PhotoTwoService;
import org.taru.vo.JsonResult;
import org.taru.vo.two.Pictures;


@RestController
@CrossOrigin
public class PhotoTwoServlet {
    @Autowired
    PhotoTwoService photoTwoService;
    /**
     * 上传图片(传5张图片)
     */
    @ApiOperation(value = "上传图片(传5张图片)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pictures", defaultValue = "1", value = "pictures", required = true, paramType = "Object"),
    })
    @RequestMapping(value = "/api/upload/photo", method = RequestMethod.POST)
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
