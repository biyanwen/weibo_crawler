package com.github.biyanwen.parse;

import com.github.biyanwen.pojo.MarkDownBean;

import java.util.Map;

/**
 * html 解析
 * @author 10644
 */
public interface HtmlParse {

    /**
     * 解析
     *
     * @param url       访问地址
     * @param cookieMap cookies
     * @return MarkDownBean
     */
    MarkDownBean parse(String url, Map<String, String> cookieMap);
}
