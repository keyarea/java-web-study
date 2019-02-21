package net.fangcun.service.impl;

import net.fangcun.dao.impl.UserImpl;
import net.fangcun.domain.User;
import net.fangcun.service.IUserService;

public class UserServiceImpl implements IUserService {
    private static UserServiceImpl instance;

    @Override
    public User loginUser(String name, String password){
        UserImpl userImpl = UserImpl.getInstance();
        return userImpl.find(name, password);
    }

    public static final UserServiceImpl getInstance(){
        if (instance == null) {
            try {
                instance = new UserServiceImpl();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
