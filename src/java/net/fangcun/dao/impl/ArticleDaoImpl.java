package net.fangcun.dao.impl;

import com.sun.deploy.uitoolkit.impl.awt.AWTAppletAdapter;
import net.fangcun.dao.IArticleDao;
import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.User;
import net.fangcun.util.JdbcUtils_C3P0;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticleDaoImpl implements IArticleDao {
    private static IArticleDao instance;

    public static IArticleDao getInstance(){
        if(instance == null){
            try{
                instance = new ArticleDaoImpl();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }

    @Override
    public Article[] find(Category category){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Article>  articles = new ArrayList<>();
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();

            // 要执行的sql语句
            String sql = "SELECT * FROM article WHERE category = " + category.getId();

            //
            statement = connection.createStatement();

            //
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Article article = new Article();
                // 设置id
                article.setId(String.valueOf(resultSet.getInt("id")));
                // 设置文章内容
                article.setContent(resultSet.getString("content"));
                // 设置文章标题
                article.setTitle(resultSet.getString("title"));
                // 设置文章创建时间
                article.setCreateTime(resultSet.getTimestamp("createTime"));
                // 设置文章更新时间
                article.setUpdateTime(resultSet.getTimestamp("updateTime"));
                // 将该对象添加到数组
                articles.add(article);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }
        return articles.toArray(new Article[articles.size()]);

    }

    @Override
    public Article[] find(User user){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Article>  articles = new ArrayList<>();
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();

            // 要执行的sql语句
            String sql = "SELECT * FROM article WHERE author = " + user.getId();

            //
            statement = connection.createStatement();

            //
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Article article = new Article();
                // 设置id
                article.setId(String.valueOf(resultSet.getInt("id")));
                // 设置文章内容
                article.setContent(resultSet.getString("content"));
                // 设置文章标题
                article.setTitle(resultSet.getString("title"));
                // 设置文章创建时间
                article.setCreateTime(resultSet.getTimestamp("createTime"));
                // 设置文章更新时间
                article.setUpdateTime(resultSet.getTimestamp("updateTime"));
                // 将该对象添加到数组
                articles.add(article);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }
        return articles.toArray(new Article[articles.size()]);

    }
}
