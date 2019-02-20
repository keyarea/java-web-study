package net.fangcun.dao.impl;

import com.sun.xml.internal.bind.v2.TODO;
import net.fangcun.dao.IUserDao;
import net.fangcun.domain.User;
import net.fangcun.util.JdbcUtils_C3P0;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserImpl implements IUserDao {

    @Override
    public User find(String name, String password){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try{
            user = new User();
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "SELECT id,name,nickname FROM user WHERE name = '" + name + "' AND password = '" + password + "'";
            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();
            // 执行查找操作
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                // 设置用户id
                user.setId(String.valueOf(resultSet.getInt("id")));
                // 设置用户名
                user.setName(resultSet.getString("name"));
                // 设置昵称
                user.setNickname(resultSet.getString("nickname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }
        return user;

    }

    @Override
    public User find(String name) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try{
            user = new User();
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "SELECT id,name,nickname FROM user WHERE name = '" + name + "'";
            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();
            // 执行查找操作
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                // 设置用户id
                user.setId(String.valueOf(resultSet.getInt("id")));
                // 设置用户名
                user.setName(resultSet.getString("name"));
                // 设置昵称
                user.setNickname(resultSet.getString("nickname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }
        return user;
    }


    // TODO 添加用户
    @Override
    public void add(User user) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            user = new User();
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "";
            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();
            // 执行查找操作
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                // 设置用户id
                user.setId(String.valueOf(resultSet.getInt("id")));
                // 设置用户名
                user.setName(resultSet.getString("name"));
                // 设置昵称
                user.setNickname(resultSet.getString("nickname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }
    }
}
