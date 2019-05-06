package net.fangcun.service.impl;

import net.fangcun.dao.IArticleDao;
import net.fangcun.dao.ICategoryDao;
import net.fangcun.dao.impl.ArticleDaoImpl;
import net.fangcun.dao.impl.CategoryDaoImpl;
import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
    private static CategoryServiceImpl instance = null;

    private CategoryServiceImpl(){}

    public static CategoryServiceImpl getInstance(){
        if(instance == null){
            try{
                instance = new CategoryServiceImpl();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }


    @Override
    public Category find(int id){
        ICategoryDao categoryDao = CategoryDaoImpl.getInstance();
        return categoryDao.find(id);
    }

    @Override
    public boolean addCategory(Category category){
        ICategoryDao categoryDao = CategoryDaoImpl.getInstance();
        return categoryDao.add(category);
    }

    @Override
    public Category[] find(){
        ICategoryDao categoryDao = CategoryDaoImpl.getInstance();
        return categoryDao.find();
    }

    @Override
    public boolean delete(int id){
        ICategoryDao categoryDao = CategoryDaoImpl.getInstance();
        return categoryDao.delete(id);
    }

    @Override
    public Category addArticles(Category category){
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        Article[] articles = articleDao.find(category);
        category.setArticles(articles);
        return category;
    }

    @Override
    public Category[] addArticles(Category[] categories){
        for(int i = 0, l = categories.length;i < l; i++){
            categories[i] = addArticles(categories[i]);
        }
        return categories;
    }

    @Override
    public boolean updateCategory(Category category){
        ICategoryDao categoryDao = CategoryDaoImpl.getInstance();
        return categoryDao.update(category);
    }
}
