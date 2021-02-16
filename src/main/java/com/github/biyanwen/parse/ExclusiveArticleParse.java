package com.github.biyanwen.parse;

import com.github.biyanwen.enums.HtmlTagEnum;
import com.github.biyanwen.enums.TitleLevel;
import com.github.biyanwen.helper.ImageHelper;
import com.github.biyanwen.pojo.MarkDownBean;
import com.github.biyanwen.pojo.MarkDownTitleBean;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
        Elements elements = getElementsByMainEditor(mainEditor);
        StringBuilder stringBuilder = new StringBuilder();
        elements.forEach(element -> {
            String result = getResultByElement(element);
            stringBuilder.append(result).append(System.lineSeparator());
        });
        markDownBean.setTitle(new MarkDownTitleBean(TitleLevel.ONE.getIndex(), title))
                .setPointOfView(pointOfView)
                .setText(stringBuilder.toString());

        return markDownBean;
    }

    private Elements getElementsByMainEditor(Elements mainEditor) {
        //不同排版的文章html结构不同
        Elements elements;
        elements = mainEditor.select(".main_editor > .WB_editor_iframe_new > *");
        if (elements.size() == 0) {
            elements = mainEditor.select(".main_editor > .WB_editor_iframe_word > *");
        }
        return elements;
    }

    private String getResultByElement(Element element) {
        String result;
        result = getImageUrl(element);
        if (result != null) {
            return result;
        } else {
            result = getElementText(element);
        }
        return result;
    }

    private String getElementText(Element element) {
        String result = element.text();
        if (isTag(element.tagName(), HtmlTagEnum.blockquote)) {
            result = "> " + element.text();
        }
        return result;
    }

    private String getImageUrl(Element element) {
        String url = null;
        Element image = element.select("img").first();
        if (image != null) {
            url = image.absUrl("src");
        }
        return ImageHelper.urlBoxing(url);
    }
}
