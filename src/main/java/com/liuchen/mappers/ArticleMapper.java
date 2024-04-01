package com.liuchen.mappers;

import com.liuchen.models.db.Article;
import com.liuchen.models.dto.ArticleDto;
import lombok.Data;

/**
 * Package: com.liuchen.mappers
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/1/2024 - 9:59 AM
 * @Version: v1.0
 */

@Data
public class ArticleMapper {

    public ArticleDto ArticleToDto(Article articleDB){

        ArticleDto articleDto = new ArticleDto();
        articleDto.setAid(articleDB.getId());
        articleDto.setAuthor(articleDB.getAuthor());
        articleDto.setDescription(articleDB.getDescription());
        return articleDto;

    }

}
