package com.neuedu.shop.common;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102100729357";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCZNFMV4vjz7nP6CFkIeN0OfxIiinrbh9csbizbNVPHy+ab+y0R9FvWLzwsEQH0NhpAHSNnEVC0ZQAzjHQ4sNTvmS9Lx44RFKKD8PKlY3AY+JHJEdrXeGvSoGrzqB8wJ76vzMuOPcQVYgJTPXPk8Nj1RDQ8T3cWtQ7n+Ok8BmnIYLbIGPu8/odFJ1ppYfpBUj2hnmIVveo1BGkYmzAOiJ767dFJZz3/QcXB0KMOsR148UfCWTwvAaukY++NHvXW9tiDQT29t4kJFOab0MFAeXh7WRF3FJjI9LJgDQjlX1S8gOkzMGD9Ef8HMQePo4dN2BGCAyBuTEGMiUnzM7cQiZ4bAgMBAAECggEAJOQRobKO6gYgTTPXZI/eAxCcKE8aOGSkbqF1Ea/spa62sBayiqFBv/iNz7qkss6YUZnynW3w9g9gFgmbLs995tgHKIM79Wb3nzfU5fhk1M5+JGG1Ra9Mn2JbfqKcJ/daFnEFDxJWdiOslai1kIpiY+TxgxhLf99HYJpyZy7QKByqQ6uiXWMTa/F0x7/qLdMc900sZmtkMNYI786RzS0zllbBOsxXc/hdzdpP0rOYLMRnlVcklqM14cXjw5hWvknCFq3vGnIfMSwVxNVZP8U/iV+uGNxDDv9IANfjBzZUW7Mzam+4KKsr7ka14gzjJDU4KyhZjtvqXMH8MoQPfiEB6QKBgQDQ6BVWpx85uEcJdEacNr2alCYimf3DXMfQ9Pn40KCVVoxfopBbZ0Hd5NOoHclV1eXrqhrLgImWAGw32JEMxwEihufodRkBYyB2A7fX1u+XotWvZ0UwJQZqCmE+v28frQ41GH2ZnhY5q2qNRSyXyUyWTyxivcX2s3MkNx0cXv6qTQKBgQC7vbCm/9HCuMZqBGSca1cgWEy6pdFWUqkn5sXNhuOpWwTfLIg8koT+t26rZ3crHuw1LqJ/tOmZElzBhynUxk25vf227yarzWsnVjOUV4pPsnPqcqlWQa9CipbRDqM9m9+JCmjDojftwqUjig8HxKYDr0kxK71QXmjpuKUhhy3OBwKBgHyzDIm9GJaLuVubXMrCokszQ9BDu4ZyS5Qfp1cusaxzDTfJAgKNkHOzs+QWY6gpFiWmVHhFMduoRPDRBURrRfImNSg9Pb/mO+o2LfdZBYuuV39sVZB3iWyi5YlfHCX8Vw66n76i7wFdoSzSrdus/Vp7yDLotNKeK4zimS3mRn3BAoGAcSDNyOPQPzjeftXk1oir+Jacrb/rk8u9mIir2rwUhWGOXvjTo0RbFa3s5yYyne5FQYq3aqLWPGHfONK8tzVDctB0iP403EOs9QgxjortkjajOLwdJBfyhvNCC/l5Dk/V9Bsso+4lK4Ulw3OWuQSbUQ8X2KRVsI8jQur7vmdZh5MCgYEArKfKOGpgXsOxRdc+LvyxSixCHBzJys3MQFhi4qOSpIkrD419F64XzljORl35NU/NnRpxhCT7++aqeX0mepgO3IKjq5E+uzQocofAuf5eXRPhMbQaPxGubktq31NptIzR1jjPm4qipKA8rwTyycWLEO30SbqaKTCa1+QhKnR4Rbk=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlDE9is/joV/yxnRuBLqsgX8ep6Zu65B01NMd3WE+EWDCyN+IOmqV3EEZjEqqf7B/bbNYPFsKy2boyqqsOURAE8VrQAmeOCZIB67uBPNDpowlooQWlTIvX9oX2RBJaogF4G3BPvIG+QyWi4xY8HjPgHkhUfwMzq9G30WVzytu9WRwpdN2IfU4Seb9QU8Aty96wFEgy8KWAm+K6TgdbYLM56Lp85TdhRTQwRJhM96ni8AKhx1M3RYOkyrwkhqMbQJHBlpZmulaoqxQfqzhyvDIi/S3pV6K4w3AmHGJw7vVqg9K/dpvzkTpvtteuqfRVdXrQRivVcOKrlhjO9Oi69LWrQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://nonameming.natapp1.cc/tygy-shop/alipay/notify_url.jsp";

//    http://nonameming.natapp1.cc/tygy-shop/back/index.jsp

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://nonameming.natapp1.cc/tygy-shop/pre/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "UTF-8";

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
