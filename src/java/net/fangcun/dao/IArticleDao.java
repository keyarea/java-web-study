package net.fangcun.dao;

import net.fangcun.domain.Article;
import net.fangcun.domain.Category;
import net.fangcun.domain.Tag;
import net.fangcun.domain.User;

public interface IArticleDao   {

    /**
     * 通过分类得到文章
     * @param category
     * @return
     */
    Article[] find(Category category);

    /**
     * 得到某个用户所写的文章
     * @param user
     * @return
     */
    Article[] find(User user);


    /**
     * 得到某个标签的文章
     * @param tag
     * @return
     */
    Article[] find(Tag tag);

    /**
     * 得到所有的文章
     * @return
     */
    Article[] find();

    /**
     * 根据id找到对应的文章
     * @param id
     * @return
     */
    Article find(int id);

    /**
     * 根据id来删除文章
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 创建一个新的文章,并返回自增列
     * @param article
     * @return
     */
    int insert(Article article);


    /**
     * 给文章在数据库中关联分类
     * @param article
     * @return
     */
    boolean addCategory(Article article);

    /**
     * 给文章关联多个标签
     * @param article
     * @return
     */
    boolean addTags(Article article);

    /**
     * 更新文章,并返回是否更新成功
     * @param article
     * @return
     */
    boolean update(Article article);

    /**
     * 删除文章关联的标签
     * @param article
     * @return
     */
    boolean deleteTags(Article article);

    /**
     * 删除文章关联的分类
     * @param article
     * @return
     */
    boolean deleteCategory(Article article);

    /**
     * 查询文章数量
     * @return
     */
    int count();

    /**
     * 得到文章
     * @param limit
     * @param skip
     * @return
     */
    Article[] find(int limit, int skip);
}

