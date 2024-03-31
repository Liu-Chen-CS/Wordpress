package com.liuchen.models.db.block;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class ArticleBlock {

    @Column(name = "sort_index")
    private int sortIndex;

}
