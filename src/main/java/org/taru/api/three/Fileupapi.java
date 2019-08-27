package org.taru.api.three;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.taru.vo.JsonResult;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

/**
 * 上传文件
 */


@ApiOperation(value="上传文件",notes="注意参数")
@ApiImplicitParams({
        @ApiImplicitParam(name = "file", value = "文件名", required = true, paramType = "String")
})
@RequestMapping(value = "/common",method = RequestMethod.GET)
@RestController
public class Fileupapi {
    File uploadPath = null;

    //单文件上传
    @PostMapping("/upload")
    public JsonResult upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws Exception{
        //定义返回客户端json对象
        JsonResult returnData =null;
        //定义处理流对象
        BufferedOutputStream out = null;
        //将request对象转成JSONObject对象
        // JSONObject jsonObject = CommonUtil.request2Json(request);
        //验证必填字段
        //   CommonUtil.hasAllRequired(jsonObject,"user_id,equi_id,upload_type");

        //获取当前用户id
        // String user_id = jsonObject.getString("user_id");
        //获取当前设备id
        //   String equi_id = jsonObject.getString("equi_id");
        //获取上传文件的类型 1:巡检 2:维保
        // String upload_type = jsonObject.getString("upload_type");

        //判断上传文件类型并设置前置路径
        File uploadPath = null;
        String basePath = "F:\\images";                  //基础文件上传路径
        uploadPath = new File(basePath);
        //判断服务器上传文件夹是否存在
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        //判断上传的文件是否为空
        if (file!=null) {
            //获取上传文件后缀
            String houzhui = file.getOriginalFilename().split("\\.")[1];
            //拼接上传文件保存路径(当前用户id+设备id+时间戳.后缀名)
            File fil = new File(uploadPath+"/"+new Date().getTime()+"."+houzhui);
            try {
                //将上传文件保存到服务器上传文件夹目录下
                out = new BufferedOutputStream(new FileOutputStream(fil));
                out.write(file.getBytes());
                out.flush();
                out.close();
                //返回上传文件的访问路径   getAbsolutePath()返回文件上传的绝对路径
                returnData=new JsonResult("200", "成功", file.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                returnData=new JsonResult("400", "失败", e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                returnData=new JsonResult("402", "失败", e.getMessage());
            }finally {
                //关闭处理流
                if(out!=null){out.close();}
            }
        } else {
            returnData=new JsonResult("404", "上传文件为空", "");
        }
        return returnData;
    }
}
