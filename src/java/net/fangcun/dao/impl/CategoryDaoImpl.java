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
                // 设置类别下文章
                IArticleDao articleDao = ArticleDaoImpl.getInstance();
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
}
