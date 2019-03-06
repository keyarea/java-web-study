package net.fangcun.dao;

import net.fangcun.domain.User;

public interface IUserDao {
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
     * 添加用户
     * @param user
     */
    void add(User user);

    /**
     * 得到条件限制的部分用户
     * @param start 开始
     * @param limit 多少个
     * @return 用户列表
     */
    User[] getPartUsers(int start, int limit);
}
