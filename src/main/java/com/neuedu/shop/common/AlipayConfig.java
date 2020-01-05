package com.neuedu.shop.common;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102100729357";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCq9MQRU76FQWQwbfAVlqAAMcUEBNUThrsrIAw763Rqc/k+x6soitt19474zV0UV6f18I0faai181perEsvyhFsc8gaFX4Shjkqwt34jOIiu0iDBhs+1Omk61X3y7Jt/E1V3hGGUegpTYp8pIIYVMbRqAZMJS9zbDH9JhdjAR2UzOSCiY6PoOiNeT4uEXWqvxLYL+JRDDF5EHUugCIZldBJzq6RNiLMaiIILDw09UzT7jd3WRITQu4KO4/GB61WEwMEuf8un7UIaRGzaSN9IcBFLXgwJeBcBJ4Nl3qh7YpXqLaqKwoCQ/rVSeHQLhZ8uaWcm8xcHBfdWaeWhll/2lJ7AgMBAAECggEAWB3ZgeTcausNrTi9ayM8TV1Z43xqJ6pmhw/5vljapJQqgIWCX19TRzbW5r9TnsyfslDPLMXVRBOvHOVJy9QnrvLuzSMO3JV6mePfbeGQHb7S3VYkbPppg6wZn6PK0I4ffob8GXPWapOhMiXJOKlZ4W7t8Amqr5+xFH6xx0In8S3iABGirBhD+ozbPaaoGyUp2vm24B0FKV/jqVG3GklYOQibPhZoXNpQ3ghGiLIZ0fIqoCQCvMaB88rGpjBOmZZ0zio4mtx7cfdD1+Hzv5HaXRWqOQJh9EpGCSHwbnr9fJd1qDszCi3yMBcR2DgCeaq7UEHSpW7LTjAfBtkyz4c3wQKBgQDqPy3lnnUiFM4XDuTBDCGUOfJtrU7ioGRocuEvmRquip3oEl03qBu6Ro67aaQnUhjbU9ehk6xZ0faFJnjPmhYJQUrhtqRy+RU+6lfETqcz8lTcObN/F3Iii05y8AnWbFgqqnuXym4Rz94wXOcepOVwV1I6f5xR8hwwPikaghDlswKBgQC61PU9OVsvfMEtaHWBhvX5FbXBzf9pp+tl0OQHeqCFILQnPJlkflknVjwxCAAZQpGS7bV/KhBEqLKyxD7kcxsW4+hRqSwqwqSv1w8pZLKstPD8nPS08amIm+aPGnn38k9Y+6WpC5msh5vgn7vG7ylSYSrexeeIGgTFKyJk+BKMGQKBgQCRoFuBP+SkHnkNPrYaCdeqVegQJUlAfORPRvQV6kH7NrP6fcgz/K/YO1sqyf9CbriDSflpOuxQHsb6ejNrJOkEMfJCppBP5eg+Z+POZ/NsyP/WtYyQu1u6fA52SCJlio+5XqldcXzCWA9S077ffzYghDjbo0/kZfb+Sva0wx2MHwKBgQCGsOaIF+R8LLVb1hX4pmKICzW4nZkIA635/gmWtroon7YhH1f6kfgWGt5T/s+LZmlqgoK5RYrq5K/HnyE0MyORcgbXcF3OCfsOZb2het4xElU12LW2CQ7O1I34Fv9dWEwJ+4mngBxuvGkNHDsUpPCmWjS82/IaNZ/AwWMPZaSBaQKBgQDR/yu1L1J7KoAdV2ST8iYqBGmqFhpmuTTGRj6gLxSt4rRgOuVtomKn4W8nwp1/Bs4Euo1vG1Fd8jIoYGXqHwH5ZOn5cGY4V7nivELksDmfz2p0qcgIKcbV8Qvx3dOxxtYd6MiecWBnQWHddbSAlMckNRtTzNf9R3UYo2sp8ul12Q==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqvTEEVO+hUFkMG3wFZagADHFBATVE4a7KyAMO+t0anP5PserKIrbdfeO+M1dFFen9fCNH2motfNaXqxLL8oRbHPIGhV+EoY5KsLd+IziIrtIgwYbPtTppOtV98uybfxNVd4RhlHoKU2KfKSCGFTG0agGTCUvc2wx/SYXYwEdlMzkgomOj6DojXk+LhF1qr8S2C/iUQwxeRB1LoAiGZXQSc6ukTYizGoiCCw8NPVM0+43d1kSE0LuCjuPxgetVhMDBLn/Lp+1CGkRs2kjfSHARS14MCXgXASeDZd6oe2KV6i2qisKAkP61Unh0C4WfLmlnJvMXBwX3VmnloZZf9pSewIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://http://localhost:8080/tygy-shop/alipay/notify_url.jsp";

//    http://nonameming.natapp1.cc/tygy-shop/back/index.jsp

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://http://localhost:8080/tygy-shop/alipay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "/Users/wangxiaoming/Desktop/shop/";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
