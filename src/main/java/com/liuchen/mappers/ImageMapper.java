package com.liuchen.mappers;

import com.liuchen.models.db.blocks.Image;
import com.liuchen.models.dto.ArticleBlockDto;
import com.liuchen.models.dto.ImageDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.liuchen.mappers
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/1/2024 - 10:38 AM
 * @Version: v1.0
 */
@Data
public class ImageMapper {

    public List<ArticleBlockDto> ImagesToDto(List<Image> imagesDB){

        List<ArticleBlockDto> imageDtos = new ArrayList<>();
        for(int i = 0; i < imagesDB.size(); i++){
            ImageDto imageDto = new ImageDto();
            imageDto.setIid(imagesDB.get(i).getIid());
            imageDto.setUrl(imagesDB.get(i).getUrl());
            imageDto.setImageSize(imagesDB.get(i).getImageSize());
            imageDtos.add(imageDto);
        }
        return imageDtos;
    }

}
