package com.github.biyanwen.enums;

/**
 * html tag enum
 *
 * @author 10644
 */
public enum HtmlTagEnum {
    /**
     * 引用
     */
    blockquote(1, "引用");

    private int index;
    /**
     * 注释
     */
    private String text;

    HtmlTagEnum(int index, String text) {
        this.index = index;
        this.text = text;
    }
}
