package com.insat.demo.controller;

import com.insat.demo.entity.Article;
import com.insat.demo.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artcile")
@CrossOrigin(origins = "*")
public class ArtcileController {
    @Autowired
    ArticleService articleService;


    @GetMapping("/all")
    public List<Article> getArticles()
    {
        List<Article> articles = this.articleService.getAllArticals();
        return articles;
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable("id") Long Id)
    {
        Article article = this.articleService.getArticleById(Id);
        return article;
    }
    @PostMapping("/create")
    public Article createNewarticle(@RequestBody Article newArticle)
    {
        Article article = this.articleService.createArtcile(newArticle);
        return article;
    }
}
