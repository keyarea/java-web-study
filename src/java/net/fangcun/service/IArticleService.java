package net.fangcun.service;

import net.fangcun.domain.Article;

public interface IArticleService {

    /**
     * 给文章添加分类
     * @return
     */
    Article addCategory();

    /**
     * 给文章添加标签
     * @return
     */
    Article addTag();

    /**
     * 给文章添加作者
     * @return
     */
    Article addAuthor();
}
