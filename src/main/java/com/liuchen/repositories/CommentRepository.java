package com.liuchen.repositories;

import com.liuchen.models.db.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Package: com.liuchen.repositories
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 2:32 PM
 * @Version: v1.0
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Transactional
    @Modifying
    @Query("from Comment c where c.article.aid = ?1")
    List<Comment> findArticleById(Long id);

}
