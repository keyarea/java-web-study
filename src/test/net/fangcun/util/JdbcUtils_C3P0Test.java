package net.fangcun.util;

import org.junit.Test;
import net.fangcun.util.JdbcUtils_C3P0;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import static org.junit.Assert.*;

public class JdbcUtils_C3P0Test {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    @Test
    public void getConnection() {
        try{
            // 得到连接
            connection = JdbcUtils_C3P0.getConnection();
            // 通过连接创建执行sql语句的statement
            statement = connection.createStatement();
            // 执行的sql语句
            String sql = "SELECT * from user";
            // 执行
            resultSet = statement.executeQuery(sql);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            // 得到行数
            int columnCount = rsmd.getColumnCount();
            // 得到结果
            System.out.println(columnCount);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            System.out.println("JdbsUtils_C30Test.getConnection end");
        }
    }

    @Test
    public void release() {
        try{
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            System.out.println("JdbsUtils_C30Test.release end");
        }
    }
}