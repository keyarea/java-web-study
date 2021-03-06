package net.fangcun.service.impl;

import net.fangcun.dao.IArticleDao;
import net.fangcun.dao.IUserDao;
import net.fangcun.dao.impl.ArticleDaoImpl;
import net.fangcun.dao.impl.UserDaoImpl;
import net.fangcun.domain.Article;
import net.fangcun.domain.User;
import net.fangcun.service.IUserService;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements IUserService {
    private static UserServiceImpl instance;

    @Override
    public User findUser(int id){
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        return userDao.find(id);
    }

    @Override
    public User findUser(String name){
        IUserDao userDao = UserDaoImpl.getInstance();
        return userDao.find(name);
    }

    @Override
    public User loginUser(String name, String password){
        UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
        return userDaoImpl.find(name, password);
    }

    @Override
    public Boolean logoutUser(HttpSession session) {
        Boolean flag = true;
        try{
            session.removeAttribute("user");
        }catch (Exception e){
            flag = false;
        }finally {
            return flag;
        }

    }

    @Override
    public boolean deleteUser(int id) {
        return UserDaoImpl.getInstance().delete(id);
    }

    @Override
    public boolean addUser(User user) {
        IUserDao userDao = UserDaoImpl.getInstance();
        return userDao.add(user);
    }

    @Override
    public boolean updateUser(User user) {
        IUserDao userDao = UserDaoImpl.getInstance();
        return userDao.update(user);
    }

    @Override
    public User[] findAllUsers() {
        IUserDao userDao = UserDaoImpl.getInstance();
        return userDao.find();
    }

    @Override
    public User addArticles(User user){
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        Article[] articles = articleDao.find(user);
        user.setArticles(articles);
        return user;
    }

    @Override
    public User[] addArticles(User[] users){
        for(int i = 0,l = users.length;i < l;i++){
            users[i] = addArticles(users[i]);
        }
        return users;
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
