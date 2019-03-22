package net.fangcun.service.impl;

import net.fangcun.dao.ICategoryDao;
import net.fangcun.dao.impl.CategoryDaoImpl;
import net.fangcun.domain.Category;
import net.fangcun.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
    private static CategoryServiceImpl instance;

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
    public Category[] find(){
        ICategoryDao categoryDao = CategoryDaoImpl.getInstance();
        return categoryDao.find();
    }

    @Override
    public boolean delete(int id){
        ICategoryDao categoryDao = CategoryDaoImpl.getInstance();
        return categoryDao.delete(id);
    }
}
