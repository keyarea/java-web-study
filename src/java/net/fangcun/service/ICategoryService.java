package net.fangcun.service;

import net.fangcun.dao.ICategoryDao;
import net.fangcun.dao.impl.CategoryDaoImpl;
import net.fangcun.domain.Category;

public interface ICategoryService{

    /**
     * 从数据库查找所有的类别
     * @return
     */
    Category[] find();

    /**
     * 从数据库中找出这个分类
     * @param id
     * @return
     */
    Category find(int id);

    /**
     * 查看该分类名是否存在
     * @param name
     * @return
     */
    boolean isExist(String name);

    /**
     * 删除类别
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 为分类添加文章
     * @param category
     * @return 添加了分类下文章的分类
     */
    Category addArticles(Category category);

    /**
     * 为分类数组添加分类
     * @param categories
     * @return
     */
    Category[] addArticles(Category[] categories);

    /**
     * 添加一个分类
     * @param category
     * @return
     */
    boolean addCategory(Category category);

    /**
     * 更新分类
     * @param category
     * @return
     */
    boolean updateCategory(Category category);
}

