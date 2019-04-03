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

}
