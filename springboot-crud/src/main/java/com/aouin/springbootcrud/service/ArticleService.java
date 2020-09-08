package com.aouin.springbootcrud.service;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.service.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {

    ArticleDTO findArticleById(Integer id) throws Exception;
    List<ArticleDTO> getAllArticles() throws Exception;
}
