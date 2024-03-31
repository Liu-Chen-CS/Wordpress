package com.liuchen.mappers;

import com.liuchen.models.db.Article;
import com.liuchen.models.db.block.TextBlock;

import java.util.ArrayList;
import java.util.Date;

/**
 * Package: com.liuchen.mappers
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 5:21 PM
 * @Version: v1.0
 */
public class ArticleMapper {

    public Article saveArticle(Article article){
        Article mappedArticle = new Article();

        mappedArticle.setLastModified(new Date());
        mappedArticle.setLastModifiedBy("Alice Johnson");
        mappedArticle.setAuthor(article.getAuthor());
        mappedArticle.setDescription(article.getDescription());

        ArrayList<TextBlock> temp = new ArrayList<>();

//        for(int i = 0; i < article.getTextBlocks().size(); i++){
//            TextBlock textBlock = new TextBlock();
//            textBlock = article.getTextBlocks().get(i);
//            temp.add(textBlock);
//        }

        for(TextBlock textBlock : article.getTextBlocks()){
            temp.add(textBlock);
        }

        mappedArticle.setTextBlocks(temp);



//        textBlock1.setSortIndex(1);
//        textBlock1.setText(String.valueOf(article.getTextBlocks().get(0)));
//
//        textBlock2.setSortIndex(2);
//        textBlock1.setText(String.valueOf(article.getTextBlocks().get(1)));
//
//        textBlock3.setSortIndex(3);
//        textBlock1.setText(String.valueOf(article.getTextBlocks().get(2)));


        return mappedArticle;
    }

}
