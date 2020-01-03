package com.neuedu.shop.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
}
