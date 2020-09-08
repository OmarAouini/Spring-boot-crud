package com.aouin.springbootcrud.service;

import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.dto.ArticleFilter;

import java.util.List;

public interface ArticleService {

    ArticleDTO findArticleById(Integer id) throws Exception;
    List<ArticleDTO> getAllArticles() throws Exception;
    List<ArticleDTO> getArticlesByFilter(ArticleFilter articleFilter) throws Exception;
    List<ArticleDTO> getArticlesByCategory(String category) throws Exception;
}
