package com.github.biyanwen.render;

import com.github.biyanwen.pojo.MarkDownBean;

import java.lang.reflect.Field;
import java.nio.file.Path;

/**
 * @author 10644
 */
public interface Render {

    /**
     * 渲染器
     *
     * @param markDownBean
     * @return
     */
    String render(MarkDownBean markDownBean);

    /**
     * 写入到文件
     * @param markDownBean
     * @param path 路径
     */
    void render(MarkDownBean markDownBean, Path path);

}
