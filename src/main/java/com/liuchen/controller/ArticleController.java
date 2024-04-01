package com.liuchen.controller;

import com.liuchen.models.db.Article;
import com.liuchen.models.dto.ArticleDto;
import com.liuchen.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("{id}")
    public ArticleDto findArticleById(@PathVariable(name = "id") Long id){
        return articleService.findArticleById(id);
    }

}
