package com.liuchen.models.db;

import com.liuchen.models.db.blocks.Image;
import com.liuchen.models.db.blocks.Video;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

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
    private List<Video> videoList;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private List<Image> imageList;


}
