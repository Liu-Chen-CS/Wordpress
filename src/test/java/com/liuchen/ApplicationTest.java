package com.liuchen;

import com.liuchen.models.db.Article;
import com.liuchen.models.db.blocks.Video;
import com.liuchen.models.db.blocks.Image;
import com.liuchen.models.db.blocks.ImageSize;
import com.liuchen.repositories.ArticleRepository;
import com.liuchen.repositories.CommentRepository;
import com.liuchen.repositories.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 12:30 PM
 * @Version: v1.0
 */

@SpringBootTest
public class ApplicationTest {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ImageRepository imageRepository;


    @Test
    void saveAsrticle(){
        //article initialization
        Article article = new Article();
        article.setAuthor("Liu Chen");
        article.setDescription("adsad sadas ewfrgt fgvbt");
        article.setLastModified(new Date());
        article.setLastModifiedBy("Liu Chen");


        //Video initialization
        Video video1 = new Video();
        Video video2 = new Video();

        video1.setVideo("https://www.youtube.com/");
        video1.setSortedIndex(1);

        video2.setVideo("https://www.netflix.com/de-en/ ");
        video2.setSortedIndex(2);


        //Image initialization

        Image image1 = new Image();
        image1.setUrl("https://unsplash.com/");
        image1.setImageSize(ImageSize.SMALL);
        image1.setSortedIndex(1);

        Image image2 = new Image();
        image2.setUrl("https://www.pexels.com/");
        image2.setImageSize(ImageSize.MEDIUM);
        image2.setSortedIndex(2);


        Image image3 = new Image();
        image3.setUrl("https://www.flickr.com/");
        image3.setImageSize(ImageSize.LARGE);
        image3.setSortedIndex(3);

        //making the connection
        List<Video> videoList = new ArrayList<>();
        videoList.add(video1);
        videoList.add(video2);

        List<Image> imageList = new ArrayList<>();
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);

        article.setVideoList(videoList);
        article.setImageList(imageList);

        video1.setArticle(article);
        video2.setArticle(article);


        image1.setArticle(article);
        image2.setArticle(article);
        image3.setArticle(article);

        // persistence
        articleRepository.save(article);

        commentRepository.save(video1);
        commentRepository.save(video2);

        imageRepository.saveAll(imageList);


    }

    @Test
    void findArticleById(){
//        Article articleDB = new Article();
//        List<Comment> commentList = new ArrayList<>();
//
//
//        Article byId = articleRepository.findById(1L).get();
//        List<Comment> articleById = commentRepository.findArticleById(1L);
//
//        commentList.add(articleById.get(0));
//        commentList.add(articleById.get(1));
//        commentList.add(articleById.get(2));
//
//        articleDB.setAid(byId.getAid());
//        articleDB.setAuthor(byId.getAuthor());
//        articleDB.setDescription(byId.getDescription());
//        articleDB.setCommentList(commentList);
//
//        System.out.println(articleDB.getAuthor());

        articleRepository.findById(1L);
    }

}
