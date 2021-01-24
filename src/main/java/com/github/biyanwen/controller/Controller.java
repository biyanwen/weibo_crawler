package com.github.biyanwen.controller;

import com.github.biyanwen.controller.request.CrawlArticlesRequest;
import com.github.biyanwen.helper.CookieHelper;
import com.github.biyanwen.parse.ExclusiveArticleParse;
import com.github.biyanwen.parse.HtmlParse;
import com.github.biyanwen.pojo.MarkDownBean;
import com.github.biyanwen.render.MarkDownRender;
import com.github.biyanwen.render.Render;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author 10644
 */
@RestController
@RequestMapping("/web")
public class Controller {

    @PostMapping("/crawlArticles")
    public String crawlArticles(@RequestBody CrawlArticlesRequest request) {

        Map<String, String> cookieMap = CookieHelper.createCookieMap(request.getCookies());
        HtmlParse htmlParse = new ExclusiveArticleParse();
        //"https://weibo.com/ttarticle/p/show?id=2309404595914059677855#_0"
        MarkDownBean markDownBean = htmlParse.parse(request.getUrl(), cookieMap);
        Render render = new MarkDownRender();
        Path path = Paths.get(System.getProperty("user.dir") + File.separator + markDownBean.getTitle().getText() + ".md");
        render.render(markDownBean, path);

        return "success";
    }
}
