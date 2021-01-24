package com.github.biyanwen.controller.request;

/**
 * @author 10644
 */
public class CrawlArticlesRequest {
    private String cookies;

    private String url;

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
