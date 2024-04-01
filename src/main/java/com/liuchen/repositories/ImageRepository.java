package com.liuchen.repositories;

import com.liuchen.models.db.blocks.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Package: com.liuchen.repositories
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/1/2024 - 9:17 AM
 * @Version: v1.0
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("from Image i where i.article.id = ?1")
    public List<Image> findImagesById(Long id);

    @Modifying
    @Transactional
    @Query("delete from Image i where i.article.id = ?1")
    public void deleteImageById(Long id);

}
