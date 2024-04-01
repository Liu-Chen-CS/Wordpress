package com.liuchen.services;

import com.liuchen.models.db.Article;
import com.liuchen.models.db.blocks.Video;
import com.liuchen.models.dto.ArticleDto;
import com.liuchen.models.dto.VideoDto;
import com.liuchen.repositories.ArticleRepository;
import com.liuchen.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.liuchen.services
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 9:08 PM
 * @Version: v1.0
 */

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CommentRepository commentRepository;

    public ArticleDto findArticleById(){

        Article byId = articleRepository.findById(2L).get();
        List<Video> articleById = commentRepository.findArticleById(2L);

        ArticleDto articleDto = new ArticleDto();
        articleDto.setAid(byId.getId());
        articleDto.setAuthor(byId.getAuthor());
        articleDto.setDescription(byId.getDescription());

        List<VideoDto> videoDtos = new ArrayList<>();

        VideoDto videoDto1 = new VideoDto();
        VideoDto videoDto2 = new VideoDto();

        videoDto1.setVid(byId.getVideoList().get(0).getVid());
        videoDto2.setVid(byId.getVideoList().get(1).getVid());

        videoDtos.add(videoDto1);
        videoDtos.add(videoDto2);

        articleDto.setVideoDtos(videoDtos);

        return articleDto;

    }
}
