package com.liuchen.controller;

import com.liuchen.models.db.Article;
import com.liuchen.models.dto.ArticleDto;
import com.liuchen.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Package: com.liuchen.controller
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 9:11 PM
 * @Version: v1.0
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping
    public void saveArticle(@RequestBody Article article){
        articleService.saveArticle(article);
    }

    @GetMapping("{id}")
    public ArticleDto findArticleById(@PathVariable(name = "id") Long id){
        return articleService.findArticleById(id);
    }

    @GetMapping
    public List<ArticleDto> getAllArticles(){
        List<ArticleDto> allArticlesDto = articleService.findAllArticles();
        return allArticlesDto;
    }

    @GetMapping("/resource/{id}")
    public void deleteArticleById(@PathVariable(name = "id") Long id){
        articleService.deleteArticleById(id);
    }

}
