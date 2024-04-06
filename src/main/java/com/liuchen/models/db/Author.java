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
 * @Create: 4/6/2024 - 11:02 AM
 * @Version: v1.0
 */
@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @JoinTable(
            name = "author_article",
            joinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "article_id", referencedColumnName = "id")}
    )
    private Set<Article> articles = new HashSet<>();

}
