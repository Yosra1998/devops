package com.insat.demo.service;

import com.insat.demo.entity.Article;
import com.insat.demo.entity.Journal;

import com.insat.demo.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Article createArtcile(Article article) {

        Article createdArtcile = this.articleRepository.save(article);
        return createdArtcile;
    }

    public List<Article> getAllArticals() {

        List<Article> articles = (List<Article>) this.articleRepository.findAll();
        return articles;
    }

    public Article getArticleById(Long id)  {
        Optional<Article> articleData = this.articleRepository.findById(id);
        Article article=articleData.orElseThrow();
        return article;
    }
}
