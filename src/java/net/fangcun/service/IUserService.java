package net.fangcun.service;

import net.fangcun.domain.User;

import javax.servlet.http.HttpSession;

public interface IUserService {

    /**
     * 提供登录服务
     * @param name
     * @param password
     * @return
     */
    User loginUser(String name, String password);

    /**
     * 提供用户注销服务
     * @param session
     * @return
     */
    Boolean logoutUser(HttpSession session);

    /**
     * 提供根据id查找用户的服务
     * @param id 用户id
     * @return User 用户类
     */
    User findUser(int id);

    /**
     * 提供根据用户名来查找用户的服务
     * @param name 用户名
     * @return 返回一个用户类
     */
    User findUser(String name);

    /**
     * 提供根据id删除用户的服务
     * @param id 用户id
     * @return boolean 成功删除返回true，失败返回false
     */
    boolean deleteUser(int id);

    /**
     * 添加用户服务
     * @param user
     * @return 是否成功添加
     */
    boolean addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 查找全部用户
     * @return
     */
    User[] findAllUsers();

    /**
     * 为用户添加用户所写的文章
     * @return
     */
    User addArticles(User user);

    /**
     * 为多位用户添加他所写的文章
     * @param users
     * @return
     */
    User[] addArticles(User[] users);
}
