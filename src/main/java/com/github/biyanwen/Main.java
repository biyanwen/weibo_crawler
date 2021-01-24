package com.github.biyanwen;

import com.github.biyanwen.helper.CookieHelper;
import com.github.biyanwen.parse.ExclusiveArticleParse;
import com.github.biyanwen.parse.HtmlParse;
import com.github.biyanwen.pojo.MarkDownBean;
import com.github.biyanwen.render.MarkDownRender;
import com.github.biyanwen.render.Render;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author 10644
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);
    }
}
