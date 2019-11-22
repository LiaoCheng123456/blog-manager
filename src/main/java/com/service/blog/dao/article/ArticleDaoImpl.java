package com.service.blog.dao.article;

import com.service.blog.constbag.RepsitoryPool.DaoRepositoryNamePool;
import com.service.blog.constbag.RepsitoryPool.MapperRepositoryNamePool;
import com.service.blog.dao.BaseDao;
import com.service.blog.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = DaoRepositoryNamePool.DAO_IMPL_ARTICLE)
public class ArticleDaoImpl extends BaseDao implements IArticleDao {

    @Override
    public Integer addArticle(Article article) {
        return sqlSessionTemplate.insert(MapperRepositoryNamePool.MAPPER_ARTICLE + Thread.currentThread().getStackTrace()[1].getMethodName(), article);
    }

    @Override
    public Integer modifyArticle(Article article) {
        return sqlSessionTemplate.update(MapperRepositoryNamePool.MAPPER_ARTICLE + Thread.currentThread().getStackTrace()[1].getMethodName(), article);
    }

    @Override
    public Article getArticle(Article article) {
        return sqlSessionTemplate.selectOne(MapperRepositoryNamePool.MAPPER_ARTICLE + Thread.currentThread().getStackTrace()[1].getMethodName(), article);
    }

    @Override
    public List<Article> getArticleList(Article article) {
        return sqlSessionTemplate.selectList(MapperRepositoryNamePool.MAPPER_ARTICLE + Thread.currentThread().getStackTrace()[1].getMethodName(), article);
    }
}
