package net.fangcun.dao;

import net.fangcun.domain.Article;
import net.fangcun.domain.Category;

public interface IArticleDao   {

    /**
     * 通过分类得到文章
     * @param category
     * @return
     */
    Article[] find(Category category);

}

