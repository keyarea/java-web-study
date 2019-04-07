package net.fangcun.dao.impl;

import net.fangcun.dao.ITagDao;
import net.fangcun.domain.Tag;
import net.fangcun.util.JdbcUtils_C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TagDaoImpl implements ITagDao {
    private static ITagDao instance;

    public static ITagDao getInstance(){
        if(instance == null){
            try{
                instance = new TagDaoImpl();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }

    @Override
    public Tag[] find(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Tag> tags = new ArrayList<>();
        try{
            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();

            // 要执行的sql语句
            String sql = "SELECT * FROM tag";

            //通过conn对象获取负责执行SQL命令的Statement对象
            statement = connection.createStatement();

            // 执行查找操作
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Tag tag = new Tag();

                // 设置标签id
                tag.setId(resultSet.getString("id"));
                // 设置标签标题
                tag.setName(resultSet.getString("name"));
                tags.add(tag);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, statement, resultSet);
        }

        return tags.toArray(new Tag[tags.size()]);
    }

    @Override
    public Tag find(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Tag tag = null;
        try{
            tag = new Tag();

            // 获取一个数据库连接
            connection = JdbcUtils_C3P0.getConnection();

            // 要执行的sql语句
            String sql = "SELECT * FROM tag WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, String.valueOf(id));

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                tag.setId(String.valueOf(resultSet.getInt("id")));
                tag.setName(resultSet.getString("name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }

        return tag;
    }

    @Override
    public boolean delete(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isOk = false;
        try{
            connection = JdbcUtils_C3P0.getConnection();

            String sql = "DELETE FROM tag WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, String.valueOf(id));

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
    public boolean add(String name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isOk = false;
        try{
            connection = JdbcUtils_C3P0.getConnection();

            String sql = "INSERT INTO tag(name) VALUES(?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);

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
    public boolean update(Tag tag){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int i = 0;
        try {
            connection = JdbcUtils_C3P0.getConnection();

            String sql = "UPDATE tag SET name = ? WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, tag.getName());
            preparedStatement.setString(2, tag.getId());

            i = preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
        return i > 0;
    }

}
