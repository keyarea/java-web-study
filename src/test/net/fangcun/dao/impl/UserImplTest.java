package net.fangcun.dao.impl;

import org.junit.Test;
import net.fangcun.domain.User;

import static org.junit.Assert.*;

public class UserImplTest {

    @Test
    public void findPartUsers() {
        User[] users = new UserImpl().findPartUsers(3,10);

        for(int i = 0, l = users.length;i<l ;i++){
            System.out.println("id: " + users[i].getId() + " name:" + users[i].getName() + " nickname:" + users[i].getNickname());
        }
    }

    @Test
    public void find() {
        User user =  new UserImpl().find("k", "123");
        System.out.println("id: " + user.getId() + " name:" + user.getName() + " nickname:" +user.getNickname());
    }

    @Test
    public void find1() {
        User user = new UserImpl().find("k");
        System.out.println("id: " + user.getId() + " name:" + user.getName() + " nickname:" +user.getNickname());

    }

    @Test
    public void add() {
    }
}