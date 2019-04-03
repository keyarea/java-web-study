package net.fangcun.dao;

import net.fangcun.domain.Tag;

public interface ITagDao {

    /**
     * 找到所有的tag
     * @return
     */
    Tag[] find();

}
