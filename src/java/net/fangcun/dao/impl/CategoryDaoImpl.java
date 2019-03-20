package net.fangcun.dao.impl;

import net.fangcun.dao.ICategoryDao;
import net.fangcun.domain.Category;
import net.fangcun.util.JdbcUtils_C3P0;

import java.sql.Connection;
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
    public Category find(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Category> categories = new ArrayList<>();

        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();

            // 要执行的sql语句
            String sql = "SELECT id,name,nickname,password FROM user";

            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();

            // 执行查找操作
            resultSet = statement.executeQuery(sql);


            while(resultSet.next()){
                User user = new User();

                // 设置用户id
                user.setId(String.valueOf(resultSet.getInt("id")));
                // 设置用户名
                user.setName(resultSet.getString("name"));
                // 设置昵称
                user.setNickname(resultSet.getString("nickname"));
                // 设置密码
                user.setPassword(resultSet.getString("password"));

                users.add(user);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }

        // 将ArrayList转为普通数组
        User[] userList = users.toArray(new User[users.size()]);
        return userList;
    }
}
