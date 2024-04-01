package com.liuchen.models.db.blocks;

import com.liuchen.models.db.Article;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Package: com.liuchen.models.db
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/1/2024 - 9:03 AM
 * @Version: v1.0
 */

@Entity
@Table(name = "image")
@Data
public class Image extends ArticleBlock{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    private String url;

    private ImageSize imageSize;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id", unique = false)
    private Article article;

}
