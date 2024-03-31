package com.liuchen.services;

import com.liuchen.models.db.Article;

/**
 * Package: com.liuchen.services
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 5:02 PM
 * @Version: v1.0
 */
public interface ArticleService {

    void saveArticle(Article article);

    Article findArticleById(Long id);

}
