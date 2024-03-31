package com.liuchen.controllers;

import com.liuchen.models.db.Article;
import com.liuchen.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Package: com.liuchen.controllers
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 3/31/2024 - 5:05 PM
 * @Version: v1.0
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/save")
    public void saveArticle(@RequestBody Article article){
        articleService.saveArticle(article);
    }

    @GetMapping("hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/{id}")
    public Article findArticleById(@PathVariable("id") Long id){
        return articleService.findArticleById(id);
    }

}
