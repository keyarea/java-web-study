package net.fangcun.dao.impl;

import net.fangcun.service.impl.UserServiceImpl;
import org.junit.Test;
import net.fangcun.domain.User;

public class UserDaoImplTest {

    @Test
    public void findPartUsers() {
        User[] users = new UserDaoImpl().findPartUsers(3,10);

        for(int i = 0, l = users.length;i<l ;i++){
            System.out.println("id: " + users[i].getId() + " name:" + users[i].getName() + " nickname:" + users[i].getNickname());
        }
    }

    @Test
    public void find() {
        User user =  new UserDaoImpl().find("k", "123");
        System.out.println("id: " + user.getId() + " name:" + user.getName() + " nickname:" +user.getNickname());
    }

    @Test
    public void find1() {
        User user = new UserDaoImpl().find("k");
        System.out.println("id: " + user.getId() + " name:" + user.getName() + " nickname:" +user.getNickname());

    }

    @Test
    public void add() {
    }

    @Test
    public void delete() {
        UserServiceImpl.getInstance().deleteUser(1);
    }

    @Test
    public void find2() {
    }

    @Test
    public void findPartUsers1() {
    }

    @Test
    public void find3() {
    }

    @Test
    public void find4() {
    }

    @Test
    public void add1() {
    }

    @Test
    public void getInstance() {
    }
}