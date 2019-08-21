package org.taru.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class AliyunSmsUtils {

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";
    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAIyBEfW4I9q0Af";
    static final String accessKeySecret = "OD9wnwmBTu087g9c7MWjPDeIFHXM4W";

    public static SendSmsResponse sendSms(String telephone, String code) throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(telephone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("再给我两分钟");    // TODO 修改成自己的
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode("SMS_172735397");    // TODO 修改成自己的
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            System.out.println("短信发送成功！");
        } else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }

    private static int newcode;

    public static int getNewcode() {
        return newcode;
    }

    public static void setNewcode() {
        newcode = (int) (Math.random() * 9999) + 100;  //每次调用生成一位四位数的随机数
    }
//    public static void main(String[] args) throws ClientException, InterruptedException {
//        setNewcode();
//        String code = Integer.toString(getNewcode());
//
//        System.out.println("发送的验证码为：" + code);
//        //发短信
//        SendSmsResponse response = sendSms("13569206257", code);
//
//        System.out.println("短信接口返回的数据----------------");
//        System.out.println("Code=" + response.getCode());
//        System.out.println("Message=" + response.getMessage());
//        System.out.println("RequestId=" + response.getRequestId());
//        System.out.println("BizId=" + response.getBizId());
//
//    }
}