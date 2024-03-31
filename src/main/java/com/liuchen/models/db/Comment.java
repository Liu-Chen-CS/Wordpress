package com.liuchen.models.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Package: com.liuchen.models.db
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 8:19 PM
 * @Version: v1.0
 */

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "aid", unique = false)
    @EqualsAndHashCode.Exclude
    private Article article;
}
