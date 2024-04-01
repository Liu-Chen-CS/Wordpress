package com.liuchen.models.db.blocks;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Package: com.liuchen.models.db.blocks
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/1/2024 - 9:41 AM
 * @Version: v1.0
 */


@MappedSuperclass
@Getter
@Setter
abstract class ArticleBlock {

    @Column(name = "sorted_index")
    private int sortedIndex;

}
