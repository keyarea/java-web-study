package net.fangcun.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接类
 * @author keyarea
 * @since 2019-1-22 15:44
 */
public class JdbcUtils_C3P0 {
    private static ComboPooledDataSource dataSource = null;
    // 静态代码块中创建数据库连接池
    static{
        try{
            // 通过代码创建c3p0数据库连接池
            /*dataSource = new ComboPooledDataSource();
             dataSource.setDriverClass("com.mysql.jdbc.Driver");
             dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcstudy");
             dataSource.setUser("root");
             dataSource.setPassword("XDP");
             dataSource.setInitialPoolSize(10);
             dataSource.setMinPoolSize(5);
             dataSource.setMaxPoolSize(20);*/

            // 通过读取c3p0的xml配置文件创建数据源，c3p0的xml文件必须放在资源文件夹下，即：/resources
            // dataSource = new ComboPooledDataSource(); // 使用c3p0的默认配置来创建数据源
            dataSource = new ComboPooledDataSource("MySQL"); // 使用c3p0的命名配置来创建数据源

        }catch (Exception e){
            // 抛出 ExceptionInInitializerError 表明在计算静态初始值或静态变量的初始值期间发生异常。
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 从数据源中获取数据库连接
     * @return 数据库连接
     * @throws SQLException jdbc与数据库的交互出现的错误
     */
    public static Connection getConnection() throws SQLException {
        // 从数据源中获取数据库连接
        return dataSource.getConnection();
    }

    /**
     * 释放资源
     * 释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象
     * @param connection 数据库连接对象
     * @param statement 负责执行SQL命令的对象
     * @param resultSet 存储查询结果的对象
     */
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet != null){
            try{
                //  关闭存储查询结果的ResultSet对象
                resultSet.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            resultSet = null;
        }

        if(statement != null){
            try{
                // 关闭负责执行SQL命令的Statement对象
                statement.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                // 将Connection连接对象还给数据库连接池
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

}
