package com.github.biyanwen.enums;

/**
 * 标题等级枚举类
 *
 * @author 10644
 */

public enum TitleLevel {
    /**
     * 标题等级
     */
    ONE(1, "#"),
    TWO(2, "##"),
    THREE(3, "###"),
    FORE(4, "####"),
    FIVE(5, "#####"),
    SIX(6, "######");


    private int index;

    private String text;

    TitleLevel(int index, String text) {
        this.index = index;
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }

    public static TitleLevel getTitleLevelByIndex(int index) {
        for (TitleLevel value : TitleLevel.values()) {
            if (value.index != index) {
                continue;
            }
            return value;
        }
        return null;
    }
}
