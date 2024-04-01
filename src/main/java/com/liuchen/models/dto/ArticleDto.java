package com.liuchen.models.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.liuchen.models.dto
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 9:52 PM
 * @Version: v1.0
 */

@Data
public class ArticleDto extends ArticleBlockDto{

    private Long aid;

    private String author;

    private String description;

    private List<List<ArticleBlockDto>> articleBlockDtos = new ArrayList<>();

}
