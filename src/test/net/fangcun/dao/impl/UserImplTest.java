package net.fangcun.dao.impl;

import org.junit.Test;
import net.fangcun.domain.User;

import static org.junit.Assert.*;

public class UserImplTest {

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