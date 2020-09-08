package com.aouin.springbootcrud.service.impl;

import com.aouin.springbootcrud.repository.ArticleRepository;
import com.aouin.springbootcrud.service.ArticleService;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    private ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDTO findArticleById(Integer id) throws Exception {
        try {
            return this.articleMapper.toDTO(this.articleRepository.findById(id).orElseThrow(() -> new Exception("id dell'articolo non trovato!")));
        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }

    @Override
    public List<ArticleDTO> getAllArticles() throws Exception {
        try {
            return this.articleRepository.findAll().stream().map(articleMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }
}
