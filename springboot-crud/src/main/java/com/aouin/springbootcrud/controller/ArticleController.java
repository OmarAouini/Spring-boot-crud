package com.aouin.springbootcrud.controller;

import com.aouin.springbootcrud.service.ArticleService;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.dto.ArticleFilter;
import com.aouin.springbootcrud.service.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/articles")
@RestController
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() throws ServiceException {
        return new ResponseEntity<>(this.articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<ArticleDTO> getArticleById(@RequestParam Integer id) throws ServiceException {
        return new ResponseEntity<>(this.articleService.findArticleById(id), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<ArticleDTO>> getArticlesByFilter(@RequestBody ArticleFilter articleFilter) throws ServiceException {
        return new ResponseEntity<>(this.articleService.getArticlesByFilter(articleFilter), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<ArticleDTO>> getArticlesByCategory(@RequestParam List<String> categories) throws ServiceException {
        return new ResponseEntity<>(this.articleService.getArticlesByCategory(categories), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ArticleDTO> addArticle(@RequestBody ArticleDTO articleDTO) throws ServiceException {
        try {
            return new ResponseEntity<>(this.articleService.addArticle(articleDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity deleteArticle(@RequestParam Integer id) throws ServiceException {
        this.articleService.deleteArticle(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
