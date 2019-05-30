package net.fangcun.service;

import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.Tag;

public interface IArticleService {

    /**
     * 根据id来删除文章
     * @param id
     * @return
     */
    boolean deleteArticle(int id);

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

    /**
     * 插入创建一个文章
     * @param article
     * @return
     */
    boolean insert(Article article);

    /**
     * 更新文章
     * @param article
     * @return
     */
    boolean update(Article article);

    /**
     * 获取文章数量
     * @return
     */
    int ArticleCount();

    /**
     * 得到最新的文章
     * @param limit
     * @param skip
     * @return
     */
    Article[] getNewArticles(int limit, int skip);

    /**
     * 验证是不是范围内的页面
     * @param page
     * @return
     */
    boolean verifyPage(int page, int pageSize);

}
