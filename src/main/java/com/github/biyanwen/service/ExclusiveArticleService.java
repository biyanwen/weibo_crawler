package com.github.biyanwen.service;

/**
 * @author 10644
 */
public interface ExclusiveArticleService {

    public void crawlArticles(String cookies, String url);

    void crawlArticlesBatch(String cookies, String url);
}
