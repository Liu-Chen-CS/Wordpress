package com.liuchen.repositories;

import com.liuchen.models.db.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Package: com.liuchen.repositories
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/6/2024 - 11:05 AM
 * @Version: v1.0
 */

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
