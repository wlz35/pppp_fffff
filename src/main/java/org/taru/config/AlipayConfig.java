package org.taru.config;

public class AlipayConfig {

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ APPID（填自己的，下面都是改过的~）
    public static String app_id = "2016101400681759";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 生成公钥时对应的私钥（填自己的，下面都是改过的~）
    public static String private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDFLbzuvmY2kkLYP2yplW7tWMB65D8nGSFPeWSjn8fMB2zTeTUI1rcIn4tSmwEqu98usFFQI7N3WUq94JpHK3bkZOiRA4Wq8jrQs1pd58Y9Z8VrE43ZlMp10sUjeGvnXbabU/bQN3VRX1P02+kuyVBTrjyLla7GIoJFqYIToeHKQrBCjUbrODZLLGfEDeSeKePSw26fp5swnzrV9/Aj8yKihdYWDlMkooFgz9LRGDY9swtu0kuMs3zvlHocVkXcFWffqXln+ga2a+VVqAgfrS7R1mEnIx2hJoVyOh5NMX8lrPyHTDuD5GkT0SlrgbN7vcll2d81f0R1XUX5NNvm4aKHAgMBAAECggEBAKj9kjdrp16N7Aw6D38oO3Hf5tdsV1PDDfF3MPGrNyl+E58K+pEgtK4HTvj1MALYEWeKZaYxctaPCKfDn3Xvom4MreXbBuyDvjSwAnsI8bYfAevLTn90LjDc+2hzBMe+YYquY5IAdePPt7zb3PXkQ5v0cJ+RIcFeQhhCNuFslH8rNWGRmKkHesLxZFpl3mwk3pvFMSUwkMc0hx75cmQN7tpBGCGsJBfcY2Oul98TRlcUwNN/8Mt78aiMvxL7Z9nH85HWPyl1cS9VW4+EXnaW/it/JpF5bA437VuXgHQyWkTgUh0NuTA1lh/TjW9/7OSG5Bg/oi5XPr9wlK96cJWPUsECgYEA+hZA5lHgKzJTH84yVZreW0G9FjtTrftlDXI9MUDLwqkCYRRGKdHrzju1104MUAVRwOn97btw0lNIpy62EBU/O9DYl9yVjDjTbdm/ZODL2rj9cgBtiemMNSnrEYdbVruG/BvgJuzV0AOYiIQRlvLaIw67PFlIXjDgsvJJq1QCU9MCgYEAydc8sEGwQ6N+tmxQDRbliV2h6AqfmDdICl67SU8BzkWAKiNFYduEXgrNprY5j8IL7xInJvaAxjpweFI/7/b3qAVKg4v0dH0zfXpgrg+1vBNRP+AVFRYOyyS8dDw3TLv+cebGJlHuOioaA00bK91tb960e+2QWqkNT1EWJEk4Kf0CgYEA9gPqOCiXEydgaktXbKr6zl7u+e3GtcI2eHHHDKqnR4knFATzuLQO+kP28CSRLC7va41EBRd9NwpC0GO9KjkciWU7jLisTNKh+tBX3Y7eOv38JKeTGjYrfSkNW6MCEWJMublaWjBlbUn8RV9WRl4EhLQ7MHTMIgyHHsIGAoqT940CgYBw58m2/sfOzkIvYV9WMxyrPok299pWl3Xg9yTk2SE1dYNADwLcvqLIyFpJi12foPhz/z+PeAyI1l/broa9gPUANBV+iGdyUibfZfl25KrQTi4BASRJ61DTKfWRP63farnmlST6gpI0TyDF//fXDcIN9hIX0MgTLsWXPNCZ86tLMQKBgQDTjiyPR0zJ3zSXe0EV98Iom9RSDaPguuif4uPF5rE4yoWtLi1PhQ74HmIIbskS+8WQ8mokSiDpHxIBCVNs1RD7biS2zQSLR8hgNzIoo4MLoN5ZnY6+T1HdJOPsAa6oQDZ2T7IoSRoK/2lpJ2ffkD/AEEveRM6qBdD4Rtz+0uMnLw==";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String notify_url = "http://localhost/notifyUrl";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String return_url = "http://localhost/returnUrl";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
    public static String url = "https://openapi.alipaydev.com/gateway.do";

    public static String charset = "UTF-8";

    public static String format = "json";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 公钥（填自己的，下面都是改过的~）
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxS287r5mNpJC2D9sqZVu7VjAeuQ/JxkhT3lko5/HzAds03k1CNa3CJ+LUpsBKrvfLrBRUCOzd1lKveCaRyt25GTokQOFqvI60LNaXefGPWfFaxON2ZTKddLFI3hr5122m1P20Dd1UV9T9NvpLslQU648i5WuxiKCRamCE6HhykKwQo1G6zg2SyxnxA3kninj0sNun6ebMJ861ffwI/MiooXWFg5TJKKBYM/S0Rg2PbMLbtJLjLN875R6HFZF3BVn36l5Z/oGtmvlVagIH60u0dZhJyMdoSaFcjoeTTF/Jaz8h0w7g+RpE9Epa4Gze73JZdnfNX9EdV1F+TTb5uGihwIDAQAB";

    public static String signtype = "RSA2";

}
