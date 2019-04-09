package net.fangcun.dao;

import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.Tag;
import net.fangcun.domain.User;

public interface IArticleDao   {

    /**
     * 通过分类得到文章
     * @param category
     * @return
     */
    Article[] find(Category category);

    /**
     * 得到某个用户所写的文章
     * @param user
     * @return
     */
    Article[] find(User user);


    /**
     * 得到某个标签的文章
     * @param tag
     * @return
     */
    Article[] find(Tag tag);

    /**
     * 得到所有的文章
     * @return
     */
    Article[] find();

    /**
     * 根据id找到对应的文章
     * @param id
     * @return
     */
    Article find(int id);

}

