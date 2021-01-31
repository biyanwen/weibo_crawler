package com.github.biyanwen.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * cookie帮助类
 *
 * @author 10644
 */
public class CookieHelper {

    public static Map<String, String> createCookieMap(String cookie) {
        String[] split = cookie.split(";");
        Map<String, String> cookieMap = new HashMap<>(16);
        Arrays.stream(split).forEach(s -> {
            String[] singleCookie = s.split("=");
            cookieMap.put(singleCookie[0].trim(), singleCookie[1]);
        });
        return cookieMap;
    }
}
