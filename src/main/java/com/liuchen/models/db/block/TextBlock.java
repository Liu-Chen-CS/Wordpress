package com.liuchen.models.db.block;

import com.liuchen.models.db.Article;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "text")
public class TextBlock extends ArticleBlock{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    private String text;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id", unique = false)
    @EqualsAndHashCode.Exclude
    private Article article;

}