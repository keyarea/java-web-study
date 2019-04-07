package net.fangcun.dao;

import net.fangcun.domain.Tag;

public interface ITagDao {

    /**
     * 找到所有的tag
     * @return
     */
    Tag[] find();

    /**
     * 按照id查找tag
     * @param id
     * @return
     */
    Tag find(int id);

    /**
     * 根据id删除标签
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 添加一个标签
     * @param name
     * @return
     */
    boolean add(String name);

    /**
     * 修改一个标签
     * @return
     */
    boolean update(Tag tag);

}
