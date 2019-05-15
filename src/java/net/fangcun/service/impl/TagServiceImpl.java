package net.fangcun.service.impl;

import net.fangcun.dao.IArticleDao;
import net.fangcun.dao.ITagDao;
import net.fangcun.dao.impl.ArticleDaoImpl;
import net.fangcun.dao.impl.TagDaoImpl;
import net.fangcun.domain.Article;
import net.fangcun.domain.Tag;
import net.fangcun.service.ITagService;

public class TagServiceImpl implements ITagService {
    private static ITagService instance;

    public static ITagService getInstance(){
        if(instance == null){
            try{
                instance  = new TagServiceImpl();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return instance;
    }

    @Override
    public Tag addArticles(Tag tag){
        IArticleDao articleDao = ArticleDaoImpl.getInstance();
        Article[] articles = articleDao.find(tag);
        tag.setArticles(articles);
        return tag;
    }

    @Override
    public Tag[] addArticles(Tag[] tags){
        for(int i = 0,l = tags.length; i < l;i++){
            tags[i] = addArticles(tags[i]);
        }
        return tags;
    }

    @Override
    public Tag[] find(){
        ITagDao tagDao = TagDaoImpl.getInstance();
        return tagDao.find();
    }

    @Override
    public Tag find(int id){
        ITagDao tagDao = TagDaoImpl.getInstance();
        return tagDao.find(id);
    }

    @Override
    public boolean delete(int id){
        ITagDao tagDao = TagDaoImpl.getInstance();
        return tagDao.delete(id);
    }

    @Override
    public boolean add(String name){
        ITagDao tagDao = TagDaoImpl.getInstance();
        return tagDao.add(name);
    }

    @Override
    public boolean update(Tag tag){
        ITagDao tagDao = TagDaoImpl.getInstance();
        return tagDao.update(tag);
    }

    @Override
    public boolean isExist(String name){
        ITagDao tagDao = TagDaoImpl.getInstance();
        Tag tag = tagDao.find(name);
        return tag != null;
    }
}
