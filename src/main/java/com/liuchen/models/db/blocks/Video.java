package com.liuchen.models.db.blocks;

import com.liuchen.models.db.Article;
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
@Table(name = "video")
@Data
public class Video extends ArticleBlock{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vid;

    private String video;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id", unique = false)
    @EqualsAndHashCode.Exclude
    private Article article;
}
