package com.liuchen;

import com.liuchen.models.db.Article;
import com.liuchen.models.db.Comment;
import com.liuchen.repositories.ArticleRepository;
import com.liuchen.repositories.CommentRepository;
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


    @Test
    void saveAsrticle(){
        Article article = new Article();

        article.setAuthor("Liu Chen");
        article.setDescription("adsad sadas ewfrgt fgvbt");

        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        Comment comment3 = new Comment();

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);

        article.setCommentList(commentList);

        comment1.setComment("123");
        comment2.setComment("123");
        comment3.setComment("123");

        comment1.setArticle(article);
        comment2.setArticle(article);
        comment3.setArticle(article);


        articleRepository.save(article);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);

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
