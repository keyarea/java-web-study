package net.fangcun.dao.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import net.fangcun.dao.IUserDao;
import net.fangcun.domain.User;
import net.fangcun.util.JdbcUtils_C3P0;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDaoImpl implements IUserDao {

    private static UserDaoImpl instance;

    @Override
    public User[] find() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<User> users = new ArrayList<>();

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

    @Override
    public boolean delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean isOK = false;
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "DELETE FROM user WHERE id = " + id;
            //通过conn对象获取负责执行SQL命令的PreparedStatement对象
            statement = connection.prepareStatement(sql);
            // 执行查找操作
            int result = statement.executeUpdate();
            isOK = result == 1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }
        return isOK;
    }

    @Override
    public User find(int id){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "SELECT * FROM user WHERE id = " + id;
            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();
            // 执行查找操作
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                user = new User();
                // 设置用户id
                user.setId(String.valueOf(resultSet.getInt("id")));
                // 设置用户名
                user.setName(resultSet.getString("name"));
                // 设置昵称
                user.setNickname(resultSet.getString("nickname"));
                // 设置用户密码
                user.setPassword(resultSet.getString("password"));
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
    public User[] findPartUsers(int skip, int limit){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<User> users = new ArrayList<>();

        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();

            // 要执行的sql语句
            String sql = "SELECT id,name,nickname,password FROM user LIMIT " + skip + "," + limit;

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

    @Override
    public User find(String name, String password){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "SELECT id,name,nickname FROM user WHERE name = '" + name + "' AND password = '" + password + "'";
            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();
            // 执行查找操作
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                user = new User();
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
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "SELECT id,name,nickname FROM user WHERE name = '" + name + "'";
            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();
            // 执行查找操作
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                user = new User();
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


    // 添加用户
    @Override
    public boolean add(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int i = 0;
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "INSERT INTO user(name,nickname,password) VALUES(?,?,?)";
            //通过conn对象获取负责执行SQL命令的Statement对象
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getNickname());
            preparedStatement.setString(3, user.getPassword());

            i = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return i > 0;
    }

    // 升级用户
    @Override
    public boolean update(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int i = 0;
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();
            // 要执行的sql语句
            String sql = "UPDATE user SET nickname = ?,password = ? WHERE id = ?";
            //通过conn对象获取负责执行SQL命令的Statement对象
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getId());

            i = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 执行完成之后释放相关资源
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return i > 0;
    }

    public static final UserDaoImpl getInstance(){
        if (instance == null) {
            try {
                instance = new UserDaoImpl();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
