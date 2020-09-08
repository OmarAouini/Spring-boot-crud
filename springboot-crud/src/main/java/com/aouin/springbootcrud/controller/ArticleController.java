package com.aouin.springbootcrud.controller;

import com.aouin.springbootcrud.service.ArticleService;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.dto.ArticleFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() throws Exception {
        return new ResponseEntity<>(this.articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ArticleDTO> getArticleById(@RequestParam Integer id) throws Exception {
        return new ResponseEntity<>(this.articleService.findArticleById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<ArticleDTO>> getArticlesByFilter(@RequestBody ArticleFilter articleFilter) throws Exception {
        return new ResponseEntity<>(this.articleService.getArticlesByFilter(articleFilter), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getArticlesByCategory(@RequestParam String category) throws Exception {
        return new ResponseEntity<>(this.articleService.getArticlesByCategory(category), HttpStatus.OK);
    }
}
