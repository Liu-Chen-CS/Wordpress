package com.liuchen.repositories;

import com.liuchen.models.db.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Package: com.liuchen.repositories
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 12:28 PM
 * @Version: v1.0
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
