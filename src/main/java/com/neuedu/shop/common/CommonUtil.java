package com.neuedu.shop.common;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;

public class CommonUtil {
    /**
     * 文件上传
     * @param srcPath
     * @param descPath
     */
    public static void fileCopyToLocal(String srcPath,String descPath) {
        //JDK7 Files
        try {
            System.out.println("嗨，你在哪？" + descPath);
            File src = new File(srcPath);
            File dest = new File(descPath);
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMD5(String pwd) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            // 计算messageDigest5函数
            messageDigest.update(pwd.getBytes());
            // digest()最后确定返回messageDigest5 hash值，返回值为8为字符串。因为messageDigest5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
