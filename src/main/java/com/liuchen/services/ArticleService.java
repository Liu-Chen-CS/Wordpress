package com.liuchen.services;

import com.liuchen.models.db.Article;
import com.liuchen.models.db.Comment;
import com.liuchen.models.dto.ArticleDto;
import com.liuchen.models.dto.CommentDto;
import com.liuchen.repositories.ArticleRepository;
import com.liuchen.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    CommentRepository commentRepository;

    public ArticleDto findArticleById(){

//        Article articleDB = new Article();
//        List<Comment> commentList = new ArrayList<>();

        Article byId = articleRepository.findById(1L).get();
        List<Comment> articleById = commentRepository.findArticleById(1L);

        ArticleDto articleDto = new ArticleDto();
        articleDto.setAid(byId.getAid());
        articleDto.setAuthor(byId.getAuthor());
        articleDto.setDescription(byId.getDescription());

        List<CommentDto> commentList = new ArrayList<>();

        CommentDto commentDto1 = new CommentDto();
        CommentDto commentDto2 = new CommentDto();
        CommentDto commentDto3 = new CommentDto();

        commentDto1.setCid(articleById.get(0).getCid());
        commentDto1.setComment(articleById.get(0).getComment());

        commentDto2.setCid(articleById.get(1).getCid());
        commentDto2.setComment(articleById.get(1).getComment());

        commentDto3.setCid(articleById.get(2).getCid());
        commentDto3.setComment(articleById.get(2).getComment());

        commentList.add(commentDto1);
        commentList.add(commentDto2);
        commentList.add(commentDto3);

        articleDto.setCommentDtos(commentList);

        return articleDto;

//        commentList.add(articleById.get(0));
//        commentList.add(articleById.get(1));
//        commentList.add(articleById.get(2));
//
//        articleDB.setAid(byId.getAid());
//        articleDB.setAuthor(byId.getAuthor());
//        articleDB.setDescription(byId.getDescription());
//        articleDB.setCommentList(commentList);


    }
}
