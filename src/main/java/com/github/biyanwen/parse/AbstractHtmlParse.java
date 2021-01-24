package com.github.biyanwen.parse;

import com.github.biyanwen.parse.HtmlParse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractHtmlParse implements HtmlParse {

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
}
