package com.hxh.cart.config;

public class AlipayConfig2 {

    // 商户appid
    public static String app_id = "2016073100131091";
    // 私钥 pkcs8格式的
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC7eNsrV9aT0ijCCyDVOklG3qEqhPaNCC4DH02UnP3Gkq8q3l+Vlry1rnYVfNNIwJMk9UZpP7z88pJJVTAX90snRxuuifJtALm8uXJjIpOqqFHleP5NJC/7MFj0OPm1vcqcJKX5A58haNL1K9SyVyCwGY5jA1MF0oS9UuUO6mW0aN/qEwQsKrRoFa5cO0eNHmxlFw419k5p/VqAbnbAdIYfSquPMiNGGrYfUFc7fj4l6btk/BXUv2TiIaOu3o7IztTB4rG6vdtJXiAcfWKPH/cWXlQhRUHclCzgri2poeBYV2IUUTTbzoRV2UgGlQCqALj3kLBPqbrdsvqoVBLPsjebAgMBAAECggEAdcKp8aUAfeRig9lXq3ksdF7+X+YbtWVw+bcdFYA0DRsw+z2qTx3btkg7lq3NToLhKzMDIrPN9Bovd+8SAcvuImMRaWbvqDbvdTQMPWeH2IhYwUtqemyD00aAahCsEtSAQ+rlcvEqcWMWOLlqpwgB2XyEK3/4E800YnSCvAbTEipEMBzk2qE02A4lfXI/+zS8M3LOSlbVztgGFiR+FtICQFXc4rKNnV+qyJ8knqExbn4nBA8Wn5DtaawY5T7O2uppKsqPPuN8+TEpoWtrV/q7RK64Bp3frK+ArJ7Q6o6+Updrqqhfx8ANEVHU3pAG0oBolk5h1y49NwRaEndPL1xM0QKBgQD+8GResrJXCh25D8mb7yV7YEDpIoLxgEUQGiQ4RqBDrqMoBA2PwD+Hf5fVmTku93f+lGtsv7LqJvuQBgGtDU2RALsWFRaulKAUs0J3JauI22b+jm4UVMmB8pesv/1fvNngiQXOuGhjAArkxe41tk3bKaen9cQdGZR+T3jqZYeWWQKBgQC8QJX71bQkEt+HO35qcY+m/FK/fQwlagjzwVHyifjRbYNlHmiMrtKH9t/eUrd7DP2u8itq+SevkQiMJ5/CP+DIDBPp3iNSta/OHf9fOvoKkzuPX4aHAYms1p9HGjyUDP/dR6+aMwvBv0exNlxF8iFTjgbuPGIShKlHCuj9ej6nEwKBgCvWIBwcdAf9aFD7Avq6K2LEkUTFN2jZWobDR/kZQ9N/gvSNhdty/jmJWg1TdH679LkkwjgH2nbizxzbu4wLHoxRaNoKNEU+rywACuy74Hv+5f3dddYvIhsjIKuGs8Wzjm9KgGIkWWa0iir+UdCQkWCfEAIUg21RibQSbEM5xA+5AoGBAJoDOPGUr9FHg4qOuOj6yWzzR/uToYlGi9ZoldOY33DvaK0kyKI4MNO9vP+VqrjIMw+a3ryg5L/1JwoLLN/uBMeFYhFWhI2ZSSCXWCMgDAr006iDnXr8XheCa0LvixoQ3I+7o0XDd13mURABilJLOsqyCqeDzTSbRiZyHZWrGnDzAoGBAPSIzQlirl++Tbscq1PhD7uiW6sel/mi8TZDYoBXMqWJ5bRfv3G0WfyzW+wFxEdFZdz2APNcTprIs14cXbmSMJI6o8X6hDLAaQsyOz+lhRu3XXX0MkaVhzWhscXnZTDqNaAHCGVyreNam5nvJK3Nhw58u1+OeDYPWap5L7Z5DdSN";
    // 支付宝公钥
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt5l/M3CcVteD+l0ZzPR5X75R51zV0eSg8PXP2uZ8vkam8OTLfxDTAwnMAhqDrvK/jJ67KHesh1PA10E9UyBE3MFzOpi8mWwqke+vuntoJI6B6e5oEeIT67KAPPZxCtHXWLxxXOYWcoDy2xKWKfNvlpt6zou62cpb5PrjJPS25H+t++VmC2SWSOs+owWKK/ZBtUiZFdGzS82sRSG1DYLs+BQrGqRKhLueLlX4wds68SRqYUMRQ7JAtjCQAviqdnTfUWi/vWEDutMO5aliKENVFew8iDihNAZ5XlkKGdKrEtG4jYAI5AViRQ+v6Fg+Xe3yqEbNeSP6wcdEKPpRD2xxhwIDAQAB";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://localhost:8082/order/payback";
    // 请求网关地址
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String charset = "UTF-8";
    // 返回格式
    public static String format = "json";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String sign_type = "RSA2";

}
