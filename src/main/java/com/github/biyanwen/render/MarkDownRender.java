package com.github.biyanwen.render;

import com.github.biyanwen.enums.TitleLevel;
import com.github.biyanwen.helper.MarkDownAppender;
import com.github.biyanwen.pojo.MarkDownBean;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * 渲染markdown格式渲染
 *
 * @author 10644
 */
public class MarkDownRender implements Render {

    @Override
    public String render(MarkDownBean markDownBean) {
        String title = markDownBean.getTitle().getText();
        String pointOfView = markDownBean.getPointOfView();
        String text = markDownBean.getText();
        MarkDownAppender markDownAppender = MarkDownAppender.of()
                .appendTitle(title, TitleLevel.ONE)
                .appendPointView(pointOfView)
                .appenderText(text);

        renderMarkDownBeanList(markDownBean.getMarkDownBeanList(), markDownAppender);
        return markDownAppender.toString();
    }

    @SneakyThrows
    @Override
    public void render(MarkDownBean markDownBean, Path path) {
        String result = this.render(markDownBean);
        Files.write(path, result.getBytes());
    }

    private void renderMarkDownBeanList(List<MarkDownBean> markDownBeanList, MarkDownAppender markDownAppender) {
        markDownBeanList.forEach(markDownBean -> {
            getTitle(markDownBean, markDownAppender);
            String pointOfView = markDownBean.getPointOfView();
            if (pointOfView != null) {
                markDownAppender.appendPointView(pointOfView);
            }
            markDownAppender.appenderText(markDownBean.getText());
        });
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
