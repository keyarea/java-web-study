package net.fangcun.dao.impl;

import net.fangcun.dao.IArticleDao;
import net.fangcun.dao.ICategoryDao;
import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.util.JdbcUtils_C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDaoImpl implements ICategoryDao {
    private static ICategoryDao instance;

    public static ICategoryDao getInstance(){
        if(instance == null){
            try{
                instance = new CategoryDaoImpl();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }

    @Override
    public Category find(int id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Category category = null;
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "SELECT * FROM category WHERE id = " + id;
            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();
            // 执行查找操作
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                category = new Category();
                // 设置分类id
                category.setId(String.valueOf(resultSet.getInt("id")));
                // 设置分类名
                category.setName(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }
        return category;
    }

    @Override
    public Category[] find(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Category> categories = new ArrayList<>();

        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();

            // 要执行的sql语句
            String sql = "SELECT * FROM category";

            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();

            // 执行查找操作
            resultSet = statement.executeQuery(sql);


            while(resultSet.next()){
                Category category = new Category();

                // 设置类别id
                category.setId(String.valueOf(resultSet.getInt("id")));
                // 设置类别标题
                category.setName(resultSet.getString("name"));
                categories.add(category);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }

        // 将ArrayList转为普通数组
        return categories.toArray(new Category[categories.size()]);
    }

    public boolean delete(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isOK = false;
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "DELETE FROM category WHERE id = " + id;
            //通过conn对象获取负责执行SQL命令的PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            // 执行查找操作
            int result = preparedStatement.executeUpdate();
            isOK = result == 1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return isOK;
    }

    public boolean add(Category category){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int i = 0;
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "INSERT INTO category(name) VALUES(?)";
            //通过conn对象获取负责执行SQL命令的Statement对象
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, category.getName());

            i = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return i > 0;
    }

    @Override
    public boolean update(Category category){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int i = 0;
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "UPDATE category SET name = ? WHERE id = ?";
            //通过conn对象获取负责执行SQL命令的Statement对象
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getId());

            i = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return i > 0;
    }

    @Override
    public Category find(Article article){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Category category = new Category();
        try{
            String id = article.getId();

            connection = JdbcUtils_C3P0.getConnection();

            String sql = "select category.id,category.name from category join article on article.category = category.id where article.id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                category.setId(String.valueOf(resultSet.getInt("id")));
                category.setName(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return category;
    }
}
