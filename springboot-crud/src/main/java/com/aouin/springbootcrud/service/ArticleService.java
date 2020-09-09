package com.aouin.springbootcrud.service;

import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.dto.ArticleFilter;
import com.aouin.springbootcrud.service.exceptions.ServiceException;

import java.util.List;

public interface ArticleService {

    ArticleDTO findArticleById(Integer id) throws ServiceException;
    List<ArticleDTO> getAllArticles() throws ServiceException;
    List<ArticleDTO> getArticlesByFilter(ArticleFilter articleFilter) throws ServiceException;
    List<ArticleDTO> getArticlesByCategory(String category) throws ServiceException;
    ArticleDTO addArticle(ArticleDTO articleDTO) throws ServiceException;
    void deleteArticle(Integer id) throws ServiceException;
}