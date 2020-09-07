package com.aouin.springbootcrud.service.impl;

import com.aouin.springbootcrud.service.ArticleService;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public ArticleDTO findArticleById(Integer id) {
        return null;
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        return null;
    }
}
