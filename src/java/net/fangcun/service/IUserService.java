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
     * 提供根据id删除用户的服务
     * @param id 用户id
     * @return boolean 成功删除返回true，失败返回false
     */
    boolean deleteUser(int id);
}
