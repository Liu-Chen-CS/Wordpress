package com.liuchen.repositories;

import com.liuchen.models.db.blocks.Video;
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
public interface CommentRepository extends JpaRepository<Video, Integer> {

    @Transactional
    @Modifying
    @Query("from Video c where c.article.id = ?1")
    List<Video> findArticleById(Long id);

}
