package net.fangcun.domain;

import java.io.Serializable;

public class Comment implements Serializable {

    // 评论id
    private String id;
    // 文章
    private Article article;
    // 昵称
    private String nickname;
    // 联系方式
    private String contact;
    // 内容
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
