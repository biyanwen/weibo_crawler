package com.github.biyanwen.helper;

import org.apache.commons.lang3.StringUtils;

/**
 * 处理图片
 *
 * @author 10644
 */
public class ImageHelper {
    /**
     * 前缀
     */
    private static final String PREFIX = "[[";

    /**
     * 后缀
     */
    private static final String SUFFIX = "]]";

    /**
     * 对图片url进行包装
     *
     * @param url
     * @return
     */
    public static String urlBoxing(String url) {
        if (StringUtils.isEmpty(url)) {
            return null;
        }
        return PREFIX + url + SUFFIX;
    }

    /**
     * 卸下包装 与 {@link ImageHelper#urlBoxing(String)} 相反
     *
     * @param urlBoxing
     * @return
     */
    public static String urlUnboxing(String urlBoxing) {
        int startIndex = urlBoxing.indexOf(PREFIX);
        int endIndex = urlBoxing.indexOf(SUFFIX);
        return urlBoxing.substring(startIndex + 2, endIndex);
    }

    /**
     * 根据url获取图片名字
     *
     * @param url
     * @return
     */
    public static String getImageName(String url) {
        int index = url.lastIndexOf("/");
        return url.substring(index + 1);
    }

    /**
     * 判断一个字符串是否包含image url
     *
     * @param url
     * @return
     */
    public static boolean hasImage(String url) {
        return url.contains(PREFIX) && url.contains(SUFFIX);
    }

    /**
     * 转换成markdown语法
     *
     * @param imageUrl
     * @return
     */
    public static String createMarkDownUrl(String imageUrl) {
        String imageName = getImageName(imageUrl);
        //<p aligen = "center">
        //<img src="./.assets/94900170ly4gn1dw461qgj209q0f4q40.jpg" alt="image-94900170ly4gn1dw461qgj209q0f4q40.jpg" />
        //</p>
        StringBuilder builder = new StringBuilder();
        return builder.append("<p aligen = \"center\">")
                .append(System.lineSeparator())
                .append("<img src=\"./.assets/")
                .append(imageName)
                .append("\" alt=\"")
                .append(imageName)
                .append("\" />")
                .append(System.lineSeparator())
                .append("</p>")
                .toString();
    }
}
