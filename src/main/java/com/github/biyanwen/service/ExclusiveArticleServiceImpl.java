package com.github.biyanwen.service;

import com.github.biyanwen.helper.CookieHelper;
import com.github.biyanwen.parse.ExclusiveArticleParse;
import com.github.biyanwen.parse.HtmlParse;
import com.github.biyanwen.pojo.MarkDownBean;
import com.github.biyanwen.render.MarkDownRender;
import com.github.biyanwen.render.Render;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * @author 10644
 */
@Service
public class ExclusiveArticleServiceImpl implements ExclusiveArticleService {
    @Override
    public void crawlArticles(String cookies, String url) {
        Map<String, String> cookieMap = CookieHelper.createCookieMap(cookies);
        HtmlParse htmlParse = new ExclusiveArticleParse();
        MarkDownBean markDownBean = htmlParse.parse(url, cookieMap);
        Render render = new MarkDownRender();
        Path path = Paths.get(System.getProperty("user.dir") + File.separator + markDownBean.getTitle().getText() + ".md");
        render.render(markDownBean, path);
    }

    @SneakyThrows
    @Override
    public void crawlArticlesBatch(String cookies, String url) {
        System.setProperty("webdriver.chrome.driver", "D:\\tool\\web_driver\\chromedriver.exe");
        Map<String, String> cookieMap = CookieHelper.createCookieMap(cookies);
        //创建无Chrome无头参数
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("-headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);

        driver.manage().deleteAllCookies();
        cookieMap.forEach((k, v) -> {
            Cookie cookie = new Cookie(k, v);
            driver.manage().addCookie(cookie);
        });
        driver.get(url);
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(By.cssSelector("#Pl_Official_MyProfileFeed__20 > div > div:nth-child(5) > div.WB_feed_detail.clearfix > div.WB_detail > *"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        driver.close();
    }
}
