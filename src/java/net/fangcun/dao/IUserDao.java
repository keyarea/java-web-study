package net.fangcun.dao;

import net.fangcun.domain.Article;
import net.fangcun.domain.User;

public interface IUserDao {

    /**
     * 得到所有的用户
     * @return 所有的用户
     */
    User[] find();

    /**
     * 根据用户名密码来查找用户
     * @param name
     * @param password
     * @return  查找到的用户
     */
    User find(String name, String password);

    /**
     * 根据用户名来查找用户
     * @param name
     * @return 查找到的用户
     */
    User find(String name);

    /**
     * 根据主键id来查找用户
     * @param id
     * @return 查找到的用户
     */
    User find(int id);


    /**
     * 添加用户
     * @param user
     * @return boolean 是否添加成功
     */
    boolean add(User user);

    /**
     * 根据id删除用户
     * @param id 用户id
     * @return 删除成功返回true，删除失败返回false
     */
    boolean delete(int id);

    /**
     * 改变用户的数据
     * @param user
     * @return 改变成功返回true, 失败返回false
     */
    boolean update(User user);

    /**
     * 得到条件限制的部分用户
     * @param skip 开始
     * @param limit 多少个
     * @return 用户列表
     */
    User[] findPartUsers(int skip, int limit);

    /**
     * 根据文章添加作者
     * @param article
     * @return
     */
    User find(Article article);
}
