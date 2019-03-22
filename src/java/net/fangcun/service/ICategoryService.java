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
     * 删除类别
     * @param id
     * @return
     */
    boolean delete(int id);
}

