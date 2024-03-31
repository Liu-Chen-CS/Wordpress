package com.liuchen.repositories;

import com.liuchen.models.db.block.TextBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Package: com.liuchen.repositories
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 2:32 PM
 * @Version: v1.0
 */
public interface TextBlockRepository extends JpaRepository<TextBlock, Integer> {


    @Query("from TextBlock t where t.article.id = ?1")
    List<TextBlock> findTextBlockById(Long id);

}
