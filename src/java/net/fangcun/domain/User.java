package net.fangcun.domain;

import java.io.Serializable;

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
    // 用户昵称
    private String nickname;
    // 用户密码
    private String password;
    // 用户文章
    private Article[] articles;

    public Article[] getArticles() {
        return articles;
    }

    public void setArticles(Article[] articles) {
        this.articles = articles;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
