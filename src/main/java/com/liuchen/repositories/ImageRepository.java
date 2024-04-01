package com.liuchen.repositories;

import com.liuchen.models.db.blocks.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

}
