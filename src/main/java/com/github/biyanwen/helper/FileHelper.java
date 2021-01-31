package com.github.biyanwen.helper;

import java.io.File;

/**
 * 文件帮助类
 *
 * @author 10644
 */
public class FileHelper {

    /**
     * 如果文件夹不存在就创建
     *
     * @param dirPath
     */
    public static void createDirIfNot(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                throw new RuntimeException("创建文件夹失败,路径为：" + dirPath);
            }
        }
    }

    /**
     * 从文件路径中得到文件所在路径
     *
     * @param filePath 文件绝对路径，包括文件名字
     * @return
     */
    public static String getBasePath(String filePath) {
        int lastIndexOf = filePath.lastIndexOf(File.separator);
        return filePath.substring(0, lastIndexOf);
    }
}
