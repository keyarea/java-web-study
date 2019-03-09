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
     */
    User findUser(int id);

}
