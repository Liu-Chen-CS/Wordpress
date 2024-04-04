package com.liuchen.controller;

import com.liuchen.models.db.Article;
import com.liuchen.models.dto.ArticleDto;
import com.liuchen.services.ArticleService;
import com.liuchen.util.Result;
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
    public Result saveArticle(@RequestBody Article article){
        Result result = articleService.saveArticle(article);
        return result;
    }

    @GetMapping("{id}")
    public Result findArticleById(@PathVariable(name = "id") Long id){
        Result result = articleService.findArticleById(id);
        return result;
    }

    @GetMapping
    public Result getAllArticles(){
        Result result = articleService.findAllArticles();
        return result;
    }

    @DeleteMapping("/resource/{id}")
    public Result deleteArticleById(@PathVariable(name = "id") Long id){
        Result result = articleService.deleteArticleById(id);
        return result;
    }

}
