package net.fangcun.service.impl;

import net.fangcun.domain.Article;
import net.fangcun.service.IArticleService;

public class ArticleServiceImpl implements IArticleService {
    private static IArticleService instance;

    public static IArticleService getInstance() {
        if (instance == null) {
            try {
                instance = new ArticleServiceImpl();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

}
