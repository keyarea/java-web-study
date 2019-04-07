package net.fangcun.service;

import net.fangcun.domain.Tag;

public interface ITagService {

    /**
     * 给一个分类添加文章
     * @param tag
     * @return
     */
    Tag addArticles(Tag tag);

    /**
     * 给多个分类添加文章
     * @param tags
     * @return
     */
    Tag[] addArticles(Tag[] tags);

    /**
     * 查找所有分类
     * @return
     */
    Tag[] find();

    /**
     * 查找分类
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
     * 添加标签
     * @param name
     * @return
     */
    boolean add(String name);

    /**
     * 更新标签字段
     * @param tag
     * @return
     */
    boolean update(Tag tag);
}
