package com.liuchen.models.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Package: com.liuchen.models.db
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/4/2024 - 2:47 PM
 * @Version: v1.0
 */

@Entity
@Table(name = "type")
@Data
public class Type {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long tid;

    private ArticleType type;

    @ManyToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @JoinTable(
            name = "article_type",
            joinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")},
            inverseJoinColumns = {@JoinColumn(name = "aid", referencedColumnName = "id")}
    )
    private Set<Article> articles = new HashSet<>();


}
