package com.aouin.springbootcrud.service.impl;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.model.enums.Category;
import com.aouin.springbootcrud.repository.ArticleRepository;
import com.aouin.springbootcrud.service.ArticleService;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.dto.ArticleFilter;
import com.aouin.springbootcrud.service.mapper.ArticleMapper;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    private ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleMapper articleMapper) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
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

    @Override
    public List<ArticleDTO> getArticlesByFilter(ArticleFilter articleFilter) throws Exception {
        try {
            Article example = new Article();

            if (articleFilter.getId() != null)
                example.setId(articleFilter.getId());
            if (articleFilter.getName() != null && !articleFilter.getName().isEmpty())
                example.setName(articleFilter.getName());
            if (articleFilter.getPrice() != null)
                example.setPrice(articleFilter.getPrice());
            if (articleFilter.getCategory() != null && !articleFilter.getName().isEmpty())
                example.setCategory(articleFilter.getCategory());

            List<Article> result = this.articleRepository.findAll(Example.of(example));

            // min & max price filter
            if (articleFilter.getMinPrice() != null)
                result.stream().filter(a -> a.getPrice() > articleFilter.getMinPrice()).collect(Collectors.toList());
            if (articleFilter.getMaxPrice() != null)
                result.stream().filter(a -> a.getPrice() < articleFilter.getMaxPrice()).collect(Collectors.toList());

            return result.stream().map(articleMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }

    @Override
    public List<ArticleDTO> getArticlesByCategory(String category) throws Exception {
        try {
            return this.articleRepository.findByCategory(category).stream().map(this.articleMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }
}
