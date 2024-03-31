package com.liuchen.services.impl;

import com.liuchen.mappers.ArticleMapper;
import com.liuchen.models.db.Article;
import com.liuchen.models.db.block.TextBlock;
import com.liuchen.repositories.ArticleRepository;
import com.liuchen.repositories.TextBlockRepository;
import com.liuchen.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Package: com.liuchen.services.impl
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 5:02 PM
 * @Version: v1.0
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    TextBlockRepository textBlockRepository;

    @Override
    public void saveArticle(Article article) {

        Article newArticle = new Article();

        newArticle.setLastModified(new Date());
        newArticle.setLastModifiedBy("Sarah Brown");
        newArticle.setAuthor(article.getAuthor());
        newArticle.setDescription(article.getDescription());


        TextBlock textBlock1 = new TextBlock();
        TextBlock textBlock2 = new TextBlock();
        TextBlock textBlock3 = new TextBlock();

        textBlock1.setSortIndex(2);
        textBlock1.setText(article.getTextBlocks().get(0).getText());
        System.out.println(article.getTextBlocks().get(0).getText());

        textBlock2.setSortIndex(3);
        textBlock2.setText(article.getTextBlocks().get(1).getText());
        System.out.println(article.getTextBlocks().get(0).getText());

        textBlock3.setSortIndex(1);
        textBlock3.setText(article.getTextBlocks().get(2).getText());
        System.out.println(article.getTextBlocks().get(0).getText());


        ArrayList<TextBlock> textList = new ArrayList<>();
        textList.add(textBlock1);
        textList.add(textBlock2);
        textList.add(textBlock3);

        newArticle.setTextBlocks(textList);

        textBlock1.setArticle(newArticle);
        textBlock2.setArticle(newArticle);
        textBlock3.setArticle(newArticle);

        articleRepository.save(newArticle);
        textBlockRepository.save(textBlock1);
        textBlockRepository.save(textBlock2);
        textBlockRepository.save(textBlock3);

    }

    @Override
    public Article findArticleById(Long id) {


        Article articleDTO = new Article();
        List<TextBlock> textBlockList = new ArrayList<>();

        Article articleDB = articleRepository.findById(1L).get();
        List<TextBlock> TextBlockDB = textBlockRepository.findTextBlockById(1L);

        textBlockList.add(TextBlockDB.get(0));
        textBlockList.add(TextBlockDB.get(1));
        textBlockList.add(TextBlockDB.get(2));


        articleDTO.setId(articleDB.getId());
        articleDTO.setAuthor(articleDB.getAuthor());
        articleDTO.setLastModified(articleDB.getLastModified());
        articleDTO.setLastModifiedBy(articleDB.getLastModifiedBy());
        articleDTO.setDescription(articleDB.getDescription());
//        articleDTO.setTextBlocks(textBlockList);

        return articleDTO;

    }

}
