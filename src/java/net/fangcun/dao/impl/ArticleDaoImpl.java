package net.fangcun.dao.impl;

import com.sun.deploy.uitoolkit.impl.awt.AWTAppletAdapter;
import net.fangcun.dao.IArticleDao;
import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.Tag;
import net.fangcun.domain.User;
import net.fangcun.util.JdbcUtils_C3P0;

import java.sql.*;
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

    private ArticleDaoImpl(){
    }

    @Override
    public boolean delete(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isOk = false;
        try{
            connection = JdbcUtils_C3P0.getConnection();

            String sql = "DELETE FROM article WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, String.valueOf(id));

            int result = preparedStatement.executeUpdate();

            isOk = result > 0;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return isOk;

    }

    @Override
    public Article[] find(Tag tag){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Article>  articles = new ArrayList<>();
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();

            // 要执行的sql语句
            String sql = "SELECT a.id,a.title,a.content,a.createTime,a.updateTime  FROM article AS a LEFT JOIN article_tag AS at ON a.id = at.article WHERE at.tag = " + tag.getId();

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

    @Override
    public Article[] find(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Article> articles = new ArrayList<>();
        try {
            connection = JdbcUtils_C3P0.getConnection();

            String sql = "SELECT * FROM article";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

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
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return articles.toArray(new Article[articles.size()]);
    }

    @Override
    public Article find(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Article article = null;
        try{
            connection = JdbcUtils_C3P0.getConnection();

            String sql = "SELECT * FROM article WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, String.valueOf(id));

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                article = new Article();

                article.setId(String.valueOf(resultSet.getInt("id")));

                article.setTitle(resultSet.getString("title"));

                article.setContent(resultSet.getString("content"));

                article.setCreateTime(resultSet.getTimestamp("createTime"));

                article.setUpdateTime(resultSet.getTimestamp("updateTime"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return article;
    }

    @Override
    public int insert(Article article){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int id = -1;
        try{
            connection = JdbcUtils_C3P0.getConnection();

            String sql = "INSERT INTO article(title, content) VALUES(?, ?)";

            preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, article.getTitle());

            preparedStatement.setString(2, article.getContent());

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

            if(resultSet.next()){
                id = resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return id;
    }

    @Override
    public boolean addCategory(Article article){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isOk = false;
        try{
            int articleID = Integer.parseInt(article.getId());

            String categoryID = article.getCategory().getId();

            connection = JdbcUtils_C3P0.getConnection();

            String sql = "UPDATE article SET category = ? WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, categoryID);

            preparedStatement.setInt(2, articleID);


            int result = preparedStatement.executeUpdate();

            isOk = result > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);

        }
        return isOk;
    }

    @Override
    public boolean addTags(Article article){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isOk = false;
        try{
            int articleID = Integer.parseInt(article.getId());
            Tag[] tags = article.getTags();

            connection = JdbcUtils_C3P0.getConnection();

            String sql = "INSERT INTO article_tag(article, tag) VALUES(?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            connection.setAutoCommit(false);
            for(Tag tag: tags){
                preparedStatement.setInt(1, Integer.parseInt(article.getId()));
                preparedStatement.setInt(2, Integer.parseInt(tag.getId()));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            isOk = true;


        }catch (Exception e){
            e.printStackTrace();
        }finally {

            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return isOk;
    }

    @Override
    public boolean update(Article article){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isOk = false;
        try{
            int articleID = Integer.parseInt(article.getId());
            Tag[] tags = article.getTags();

            connection = JdbcUtils_C3P0.getConnection();

            String sql = "UPDATE article SET title = ?,content = ? WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, article.getTitle());

            preparedStatement.setString(2, article.getContent());

            preparedStatement.setString(3, article.getId());

            int result = preparedStatement.executeUpdate();

            isOk = result > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return isOk;
    }

    @Override
    public boolean deleteTags(Article article){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isOk = false;
        try{
            int articleID = Integer.parseInt(article.getId());

            connection = JdbcUtils_C3P0.getConnection();

            String sql = "DELETE FROM article_tag WHERE article = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, article.getId());

            int result = preparedStatement.executeUpdate();

            isOk = result > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return isOk;
    }

    @Override
    public boolean deleteCategory(Article article){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isOk = false;
        try{
            int articleID = Integer.parseInt(article.getId());

            connection = JdbcUtils_C3P0.getConnection();

            String sql = "UPDATE article SET category = ? WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setNull(1, Types.INTEGER);

            preparedStatement.setInt(2, articleID);


            int result = preparedStatement.executeUpdate();

            isOk = result > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return isOk;
    }

}
