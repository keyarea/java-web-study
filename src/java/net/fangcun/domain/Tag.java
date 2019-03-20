package net.fangcun.domain;

import java.io.Serializable;

/**
 * 标签实体类
 * @author keyarea
 *
 */


public class Tag implements Serializable {
    // 标签id
    private String id;
    // 标签名
    private String name;
    // 标签下的文章
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
