package com.github.biyanwen.parse;

import com.github.biyanwen.parse.AbstractHtmlParse;
import com.github.biyanwen.pojo.MarkDownBean;
import com.github.biyanwen.pojo.MarkDownTitleBean;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Map;

/**
 * 微博专属文章解析
 *
 * @author 10644
 */
public class ExclusiveArticleParse extends AbstractHtmlParse {
    @Override
    public MarkDownBean parse(String url, Map<String, String> cookieMap) {
        Document documentByUrl = getDocumentByUrl(url, cookieMap);
        MarkDownBean markDownBean = new MarkDownBean();
        Elements mainEditor = documentByUrl.getElementsByClass("main_editor ");
        String title = mainEditor.select(".main_editor > .title").text();
        String pointOfView = mainEditor.select(".main_editor > .preface_v2").text();
        Elements select = mainEditor.select(".main_editor > .WB_editor_iframe_new p");
        StringBuilder stringBuilder = new StringBuilder();
        select.forEach(element -> stringBuilder.append(element.text()).append(System.lineSeparator()));
        markDownBean.setTitle(new MarkDownTitleBean(title))
                .setPointOfView(pointOfView)
                .setText(stringBuilder.toString());

        return markDownBean;
    }
}
