package com.github.biyanwen.controller;

import com.github.biyanwen.controller.request.CrawlArticlesRequest;
import com.github.biyanwen.helper.CookieHelper;
import com.github.biyanwen.service.ExclusiveArticleService;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 10644
 */
@RestController
@RequestMapping("/web")
public class Controller {
    @Autowired
    ExclusiveArticleService exclusiveArticleService;

    @PostMapping("/crawlArticles")
    public String crawlArticles(@RequestBody CrawlArticlesRequest request) {
        exclusiveArticleService.crawlArticles(request.getCookies(), request.getUrl());
        return "success";
    }

    @SneakyThrows
    @PostMapping("/crawlArticlesBatch")
    public String crawlArticlesBatch(@RequestBody CrawlArticlesRequest request) {
        exclusiveArticleService.crawlArticlesBatch(request.getCookies(), request.getUrl());
        return "success";
    }
}
