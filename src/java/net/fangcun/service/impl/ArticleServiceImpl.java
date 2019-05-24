package net.fangcun.service.impl;

import net.fangcun.dao.IArticleDao;
import net.fangcun.dao.ICategoryDao;
import net.fangcun.dao.ITagDao;
import net.fangcun.dao.IUserDao;
import net.fangcun.dao.impl.ArticleDaoImpl;
import net.fangcun.dao.impl.CategoryDaoImpl;
import net.fangcun.dao.impl.TagDaoImpl;
import net.fangcun.dao.impl.UserDaoImpl;
import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.Tag;
import net.fangcun.domain.User;
import net.fangcun.service.IArticleService;
import net.fangcun.service.ICategoryService;
import net.fangcun.util.JdbcUtils_C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ArticleServiceImpl implements IArticleService {
    private static IArticleService instance = null;

    private ArticleServiceImpl(){
    }

    public static IArticleService getInstance() {
        if (instance == null) {
            try {
                instance = new ArticleServiceImpl();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    @Override
    public boolean deleteArticle(int id) {
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        return articleDao.delete(id);
    }

    @Override
    public Article addCategory(Article article){
        ICategoryDao categoryDao = CategoryDaoImpl.getInstance();
        Category category = categoryDao.find(article);

        article.setCategory(category);
        return article;
    }

    @Override
    public Article addTags(Article article){
        ITagDao tagDao = TagDaoImpl.getInstance();
        Tag[] tags = tagDao.find(article);
        article.setTags(tags);
        return article;
    }

    @Override
    public Article addAuthor(Article article){
        IUserDao userDao = UserDaoImpl.getInstance();
        User user = userDao.find(article);
        article.setAuthor(user);
        return article;
    }

    @Override
    public Article[] addCategory(Article[] articles){
        for(int i = 0,l = articles.length; i< l;i++){
            articles[i] = this.addCategory(articles[i]);
        }
        return articles;
    }

    @Override
    public Article[] addTags(Article[] articles){
        for(int i = 0,l =articles.length;i<l;i++){
            articles[i] = this.addTags(articles[i]);
        }
        return articles;
    }

    @Override
    public Article[] addAuthor(Article[] articles){
        for(int i = 0, l = articles.length;i < l;i++){
            articles[i] = this.addAuthor(articles[i]);
        }
        return articles;
    }

    @Override
    public Article[] find(){
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        Article[] articles = articleDao.find();
        return articles;
    }

    @Override
    public Article find(int id){
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        Article article = articleDao.find(id);
        return article;
    }

    @Override
    public boolean insert(Article article){
        // 得到数据库操作实例对象
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        // 将除了外键字段的数据创建一个文章，并返回自增列
        int articleID = articleDao.insert(article);
        if(articleID == -1){
            return false;
        }
        // 给文章对象增加id属性值
        article.setId(String.valueOf(articleID));

        // 关联分类
        if(article.getCategory() != null){
            boolean addCategoryResult = articleDao.addCategory(article);
        }

        // 关联标签
        if(article.getTags() != null){
            boolean addTagsResult = articleDao.addTags(article);
        }

        return true;
    }

    @Override
    public boolean update(Article article){
        //
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        boolean updatedArticle = articleDao.update(article);

        if(article.getCategory() != null){
            boolean updateCategory = articleDao.addCategory(article);
        }else{
            boolean updateCategory = articleDao.deleteCategory(article);
        }

        boolean deleteTags = articleDao.deleteTags(article);

        if(article.getTags() != null){
            boolean updateTags = articleDao.addTags(article);
        }

        return true;

    }

    @Override
    public int ArticleCount(){
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        return articleDao.count();
    }

    @Override
    public Article[] getNewArticles(int limit, int skip) {
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        return articleDao.find(limit, skip);
    }

}
