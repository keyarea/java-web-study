package net.fangcun.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author keyarea
 *
 */

public class User implements Serializable {

    // 用户id
    private String id;
    // 用户名
    private String name;
    // 用户密码
    private String password;
    // 用户邮箱
    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
