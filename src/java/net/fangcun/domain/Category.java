package net.fangcun.domain;

import java.io.Serializable;

public class Category implements Serializable {
    // 类id
    private String id;
    // 类名称
    private String name;

    // 类下的文章
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
}
