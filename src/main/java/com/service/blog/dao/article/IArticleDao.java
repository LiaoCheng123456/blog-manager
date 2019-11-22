package com.service.blog.dao.article;

import com.service.blog.model.Article;

import java.util.List;

/**
 * data driver
 */
public interface IArticleDao {

    Integer addArticle(Article article);

    Integer modifyArticle(Article article);

    Article getArticle(Article article);

    List<Article> getArticleList(Article article);
}
