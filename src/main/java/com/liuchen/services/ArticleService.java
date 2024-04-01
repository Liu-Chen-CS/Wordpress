package com.liuchen.services;

import com.liuchen.mappers.ArticleMapper;
import com.liuchen.mappers.ImageMapper;
import com.liuchen.mappers.VideoMapper;
import com.liuchen.models.db.Article;
import com.liuchen.models.db.blocks.Image;
import com.liuchen.models.db.blocks.Video;
import com.liuchen.models.dto.ArticleBlockDto;
import com.liuchen.models.dto.ArticleDto;
import com.liuchen.repositories.ArticleRepository;
import com.liuchen.repositories.ImageRepository;
import com.liuchen.repositories.VideoRepository;
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
    VideoRepository videoRepository;

    @Autowired
    ImageRepository imageRepository;

    public ArticleDto findArticleById(Long id){

        //Raw data from database
        Article articleDB = articleRepository.findById(id).get();
        List<Video> videosDB = videoRepository.findVideosById(id);
        List<Image> imagesDB = imageRepository.findImagesById(id);

        //initializing Mappers
        ArticleMapper articleMapper = new ArticleMapper();
        ArticleDto articleDto = articleMapper.ArticleToDto(articleDB);

        ImageMapper imageMapper = new ImageMapper();
        List<ArticleBlockDto> imagesDtos = imageMapper.ImagesToDto(imagesDB);

        VideoMapper videoMapper = new VideoMapper();
        List<ArticleBlockDto> videosDtos = videoMapper.videosToDto(videosDB);

        //values injection
        articleDto.getArticleBlockDtos().add(imagesDtos);
        articleDto.getArticleBlockDtos().add(videosDtos);

        return articleDto;

    }

    public List<ArticleDto> findAllArticles(){
        List<ArticleDto> articleDtos = new ArrayList<>();

        List<Article> ArticlesDB = articleRepository.findAll();

        for(int i = 0; i < ArticlesDB.size(); i++){
            Long id = ArticlesDB.get(i).getId();
            List<Video> videosDB = videoRepository.findVideosById(id);
            List<Image> imagesDB = imageRepository.findImagesById(id);

            ArticleMapper articleMapper = new ArticleMapper();
            ArticleDto articleDto = articleMapper.ArticleToDto(ArticlesDB.get(i));

            VideoMapper videoMapper = new VideoMapper();
            List<ArticleBlockDto> videosDtos = videoMapper.videosToDto(videosDB);

            ImageMapper imageMapper = new ImageMapper();
            List<ArticleBlockDto> imagesDtos = imageMapper.ImagesToDto(imagesDB);

            articleDto.getArticleBlockDtos().add(imagesDtos);
            articleDto.getArticleBlockDtos().add(videosDtos);

            articleDtos.add(articleDto);
        }
        return articleDtos;
    }


    public void saveArticle(Article article){

        // basic values injection
        ArticleMapper articleMapper = new ArticleMapper();
        Article articleDB = articleMapper.saveArticle(article);

        ImageMapper imageMapper = new ImageMapper();
        List<Image> imagesDB = imageMapper.saveImage(article.getImageList(), articleDB);

        VideoMapper videoMapper = new VideoMapper();
        List<Video> videosDB = videoMapper.saveVideo(article.getVideoList(), articleDB);

        //connection
        articleDB.setImageList(imagesDB);
        articleDB.setVideoList(videosDB);


        //persistence
        articleRepository.save(articleDB);
        videoRepository.saveAll(videosDB);
        imageRepository.saveAll(imagesDB);
    }

    public void deleteArticleById(Long id){
        articleRepository.deleteById(id);
        videoRepository.deleteVideoById(id);
        imageRepository.deleteImageById(id);
    }


}
