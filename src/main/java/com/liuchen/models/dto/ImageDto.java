package com.liuchen.models.dto;

import com.liuchen.models.db.blocks.ImageSize;
import lombok.Data;

/**
 * Package: com.liuchen.models.dto
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/1/2024 - 10:07 AM
 * @Version: v1.0
 */
@Data
public class ImageDto extends ArticleBlockDto{

    private Long iid;

    private String url;

    private ImageSize imageSize;

}
