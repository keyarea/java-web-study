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
}
