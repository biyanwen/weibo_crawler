package com.github.biyanwen.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10644
 */
public class MarkDownBean {
    /**
     * 标题
     */
    private MarkDownTitleBean title;

    /**
     * 观点
     */
    private String pointOfView;

    /**
     * 正文
     */
    private String text;

    /**
     * 一个MarkDownBean为一节内容（以标题来划分）,整篇内容有多个MarkDownBean组成
     */
    private List<MarkDownBean> markDownBeanList = new ArrayList<>();

    public MarkDownTitleBean getTitle() {
        return title;
    }

    public MarkDownBean setTitle(MarkDownTitleBean title) {
        this.title = title;
        return this;
    }

    public String getPointOfView() {
        return pointOfView;
    }

    public MarkDownBean setPointOfView(String pointOfView) {
        this.pointOfView = pointOfView;
        return this;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MarkDownBean> getMarkDownBeanList() {
        return markDownBeanList;
    }

    public void setMarkDownBeanList(List<MarkDownBean> markDownBeanList) {
        this.markDownBeanList = markDownBeanList;
    }

    public MarkDownBean addMarkDownBean(MarkDownBean markDownBean) {
        this.markDownBeanList.add(markDownBean);
        return this;
    }
}
