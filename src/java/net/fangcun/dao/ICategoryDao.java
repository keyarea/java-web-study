package net.fangcun.dao;

import net.fangcun.domain.Article;
import net.fangcun.domain.Category;

public interface ICategoryDao{

    /**
     * 找到所有分类
     * @return
     */
    Category[] find();

    /**
     * 根据id找到对应的分类
     * @param id
     * @return
     */
    Category find(int id);

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    boolean delete(int id);


    /**
     * 添加分类
     * @param category
     * @return
     */
    boolean add(Category category);

    /**
     * 更新数据库中的分类
     * @param category
     * @return
     */
    boolean update(Category category);

    /**
     * 根据文章找到分类
     * @param article
     * @return
     */
    Category find(Article article);


}

