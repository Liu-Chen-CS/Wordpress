package com.liuchen;

import com.liuchen.models.db.Article;
import com.liuchen.models.db.block.TextBlock;
import com.liuchen.repositories.ArticleRepository;
import com.liuchen.repositories.TextBlockRepository;
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
    TextBlockRepository textBlockRepository;

    @Test
    void saveArticle1(){
        Article article = new Article();
        article.setLastModified(new Date());
        article.setLastModifiedBy("Arthur Morgen");
        article.setAuthor("Liu Chen");
        article.setDescription("adsad sadas ewfrgt fgvbt");


    }

    @Test
    void deleteArticleById(){

        articleRepository.deleteById(2L);

    }


    @Test
    void saveArticle(){
        Article article = new Article();
        article.setLastModified(new Date());
        article.setLastModifiedBy("Arthur Morgen");
        article.setAuthor("Liu Chen");
        article.setDescription("adsad sadas ewfrgt fgvbt");

        TextBlock textBlock1 = new TextBlock();
        TextBlock textBlock2 = new TextBlock();
        TextBlock textBlock3 = new TextBlock();




        textBlock1.setSortIndex(2);
        textBlock1.setText("text1 for aticle1");

        textBlock2.setSortIndex(3);
        textBlock2.setText("text2 for aticle1");

        textBlock3.setSortIndex(1);
        textBlock3.setText("text3 for aticle1");


        HashSet<TextBlock> textSet = new HashSet<>();
        textSet.add(textBlock1);
        textSet.add(textBlock2);
        textSet.add(textBlock3);



        textBlock1.setArticle(article);
        textBlock2.setArticle(article);
        textBlock3.setArticle(article);



        articleRepository.save(article);

        textBlockRepository.save(textBlock1);
        textBlockRepository.save(textBlock2);
        textBlockRepository.save(textBlock3);


    }


    @Test
    void findById(){
//        Article article = new Article();
//        Optional<Article> byId = articleRepository.findById(1L);
//        Article articleDB = byId.get();
//
//        article.setId(articleDB.getId());
//        article.setAuthor(articleDB.getAuthor());
//        System.out.println(article);

//        Article article = new Article();
//        article.setId(articleDB.getId());
//        article.setLastModifiedBy(articleDB.getLastModifiedBy());
//        article.setLastModified(articleDB.getLastModified());
//        article.setAuthor(articleDB.getAuthor());
//        article.setDescription(articleDB.getDescription());
//        article.setTextBlocks(articleDB.getTextBlocks());
//        article.setComments(articleDB.getComments());
//
//
//        System.out.println(article.getId() + article.getAuthor());

        Article article = new Article();
        List<TextBlock> textBlockList = new ArrayList<>();

        Article articleDB = articleRepository.findById(1L).get();
        List<TextBlock> TextBlockDB = textBlockRepository.findTextBlockById(1L);

        textBlockList.add(TextBlockDB.get(0));
        textBlockList.add(TextBlockDB.get(1));
        textBlockList.add(TextBlockDB.get(2));


        article.setId(articleDB.getId());
        article.setAuthor(articleDB.getAuthor());
        article.setLastModified(articleDB.getLastModified());
        article.setLastModifiedBy(articleDB.getLastModifiedBy());
        article.setDescription(articleDB.getDescription());
        article.setTextBlocks(textBlockList);


    }

}
