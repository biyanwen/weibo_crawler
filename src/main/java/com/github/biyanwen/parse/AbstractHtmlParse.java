package com.github.biyanwen.parse;

import com.github.biyanwen.enums.HtmlTagEnum;
import com.github.biyanwen.helper.HtmlTagHelper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * @author 10644
 */
public abstract class AbstractHtmlParse implements HtmlParse {

    /**
     * 根据url获取 Document
     *
     * @param url
     * @param cookieMap
     * @return
     */
    protected Document getDocumentByUrl(String url, Map<String, String> cookieMap) {
        Document document = null;
        Connection connect = Jsoup.connect(url);
        if (!cookieMap.isEmpty()) {
            connect.cookies(cookieMap);
        }
        try {
            document = connect.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }


    /**
     * 判断 tag
     *
     * @param tagName
     * @param tagEnum
     * @return
     */
    protected boolean isTag(String tagName, HtmlTagEnum tagEnum) {
        return HtmlTagHelper.isTag(tagName, tagEnum);
    }
}
