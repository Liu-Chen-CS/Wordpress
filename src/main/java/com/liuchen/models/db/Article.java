package com.liuchen.models.db;

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
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    private String author;

    private String description;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private List<Comment> commentList;

}
