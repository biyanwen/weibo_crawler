package com.github.biyanwen.helper;

import com.github.biyanwen.enums.TitleLevel;
import lombok.SneakyThrows;

import java.io.IOException;

/**
 * @author 10644
 */
public class MarkDownAppender {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private Appendable appendable = new StringBuilder();

    public static MarkDownAppender of() {
        return new MarkDownAppender();
    }

    public static MarkDownAppender of(Appendable appendable) {
        return new MarkDownAppender(appendable);
    }

    public static MarkDownAppender of(MarkDownAppender markDownAppender) {
        return new MarkDownAppender(markDownAppender.getAppendable());
    }

    private MarkDownAppender() {
    }

    private MarkDownAppender(Appendable appendable) {
        this.appendable = appendable;
    }

    @SneakyThrows
    public MarkDownAppender appendTitle(String title, TitleLevel titleLevel) {
        this.appendable.append(titleLevel.getText()).append(" ").append(title).append(LINE_SEPARATOR);
        return this;
    }

    @SneakyThrows
    public MarkDownAppender appendPointView(String pointView) {
        this.appendable.append("**").append(pointView).append("**").append(LINE_SEPARATOR);
        return this;
    }

    @SneakyThrows
    public MarkDownAppender appenderText(String text) {
        this.appendable.append(text).append(LINE_SEPARATOR);
        return this;
    }

    public Appendable getAppendable() {
        return appendable;
    }

    public static String getLineSeparator() {
        return LINE_SEPARATOR;
    }

    @Override
    public String toString() {
        return appendable.toString();
    }
}
