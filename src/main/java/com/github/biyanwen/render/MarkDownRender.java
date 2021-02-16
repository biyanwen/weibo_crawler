package com.github.biyanwen.render;

import com.github.biyanwen.enums.TitleLevel;
import com.github.biyanwen.helper.FileHelper;
import com.github.biyanwen.helper.ImageHelper;
import com.github.biyanwen.helper.MarkDownAppender;
import com.github.biyanwen.pojo.MarkDownBean;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 渲染markdown格式渲染
 *
 * @author 10644
 */
public class MarkDownRender implements Render {

    private Path path;

    @Override
    public String render(MarkDownBean markDownBean) {
        MarkDownAppender downAppender = renderMarkDownBeanList(Collections.singletonList(markDownBean), MarkDownAppender.of());
        MarkDownAppender appender = renderMarkDownBeanList(markDownBean.getMarkDownBeanList(), downAppender);
        return appender.toString();
    }

    @SneakyThrows
    @Override
    public void render(MarkDownBean markDownBean, Path path) {
        this.path = path;
        String result = this.render(markDownBean);
        Files.write(path, result.getBytes());
    }

    private MarkDownAppender renderMarkDownBeanList(List<MarkDownBean> markDownBeanList, MarkDownAppender markDownAppender) {
        MarkDownAppender appender = MarkDownAppender.of(markDownAppender);
        markDownBeanList.forEach(markDownBean -> {
            getTitle(markDownBean, appender);
            String pointOfView = markDownBean.getPointOfView();
            if (pointOfView != null) {
                appender.appendPointView(pointOfView);
            }
            appenderText(markDownBean, appender);
        });
        return appender;
    }

    private void appenderText(MarkDownBean markDownBean, MarkDownAppender appender) {
        String[] texts = markDownBean.getText().split(MarkDownAppender.getLineSeparator());
        Arrays.stream(texts).forEach(text -> {
            String result = text;
            if (ImageHelper.hasImage(text)) {
                result = downLoadImageAndGetUrl(text);
            }
            appender.appenderText(result);
        });
    }

    private String downLoadImageAndGetUrl(String imageUrl) {
        String unboxing = ImageHelper.urlUnboxing(imageUrl);
        downLoadImage(unboxing);
        return ImageHelper.createMarkDownUrl(unboxing);
    }

    @SneakyThrows
    private void downLoadImage(String imageUrl) {
        URL url = new URL(imageUrl);
        URLConnection uc = url.openConnection();
        String basePath = FileHelper.getBasePath(path.toString());
        String imagePath = basePath + File.separator + ".assets";
        String imageFileName = ImageHelper.getImageName(imageUrl);
        FileHelper.createDirIfNot(imagePath);
        String imageAbsPath = imagePath + File.separator + imageFileName;
        File file = new File(imageAbsPath);
        try (
                InputStream is = uc.getInputStream();
                FileOutputStream out = new FileOutputStream(file)
        ) {

            int i;
            while ((i = is.read()) != -1) {
                out.write(i);
            }
        }

    }

    private void getTitle(MarkDownBean markDownBean, MarkDownAppender markDownAppender) {
        Integer level = markDownBean.getTitle().getLevel();
        TitleLevel titleLevel = TitleLevel.getTitleLevelByIndex(level);
        if (titleLevel == null) {
            throw new RuntimeException("没有匹配到合适的标题等级！！！");
        }
        markDownAppender.appendTitle(markDownBean.getTitle().getText(), titleLevel);
    }
}
