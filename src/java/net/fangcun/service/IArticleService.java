package net.fangcun.service;

import net.fangcun.domain.Article;

public interface IArticleService {

    /**
     * 给文章添加分类
     * @return
     */
    Article addCategory(Article article);

    /**
     * 给文章添加标签
     * @return
     */
    Article addTags(Article article);

    /**
     * 给文章添加作者
     * @return
     */
    Article addAuthor(Article article);

    /**
     * 给一个文章数组中文章全部添加分类
     * @param articles
     * @return
     */
    Article[] addCategory(Article[] articles);

    /**
     * 给一个文章数组中的文章全部添加上标签
     * @param articles
     * @return
     */
    Article[] addTags(Article[] articles);

    /**
     * 给一个文章数组中的文章全部添加上作者
     * @param articles
     * @return
     */
    Article[] addAuthor(Article[] articles);

    /**
     * 得到所有文章
     * @return
     */
    Article[] find();

    /**
     * 根据id得到文章
     * @param id
     * @return
     */
    Article find(int id);
}
