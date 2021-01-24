package com.github.biyanwen.pojo;

import java.util.Optional;

/**
 * markdown标题bean
 *
 * @author 10644
 */
public class MarkDownTitleBean {
    /**
     * 标题等级
     */
    private Integer level;

    /**
     * 标题内容
     */
    private String text;

    public MarkDownTitleBean() {
    }

    public MarkDownTitleBean(String text) {
        this.text = text;
    }

    public MarkDownTitleBean(Integer level, String text) {
        this.level = level;
        this.text = text;
    }

    public Integer getLevel() {
        //默认标题等级为2
        return Optional.ofNullable(level).orElse(2);
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
