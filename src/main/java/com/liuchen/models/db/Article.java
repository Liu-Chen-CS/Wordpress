package com.liuchen.models.db;

import com.liuchen.models.db.block.ArticleBlock;
import com.liuchen.models.db.block.TextBlock;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Package: com.liuchen.models
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 12:28 PM
 * @Version: v1.0
 */

@Entity
@Table(name = "article")
@Data
public class Article extends DBEntity{

    private String author;

    private String description;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private List<TextBlock> textBlocks;

//    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    private Set<CommentBlock> comments;

    @Transient
    private Set<ArticleBlock> articleBlocks;

}
