package net.fangcun.service;

import net.fangcun.domain.User;

public interface IUserService {

    /**
     * 提供登录服务
     * @param name
     * @param password
     * @return
     */
    User loginUser(String name, String password);
}
