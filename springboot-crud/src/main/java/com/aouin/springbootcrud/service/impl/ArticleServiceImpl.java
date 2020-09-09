package com.aouin.springbootcrud.service.impl;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.repository.ArticleRepository;
import com.aouin.springbootcrud.service.ArticleService;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.dto.ArticleFilter;
import com.aouin.springbootcrud.service.exceptions.ServiceException;
import com.aouin.springbootcrud.service.mapper.ArticleMapper;
import com.aouin.springbootcrud.service.utils.ErrMsg;
import com.aouin.springbootcrud.service.utils.TranslationService;
import com.aouin.springbootcrud.service.utils.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    private ArticleMapper articleMapper;

    private TranslationService translationService;

    private ArticleValidator articleValidator;

    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleMapper articleMapper, TranslationService translationService, ArticleValidator articleValidator) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
        this.translationService = translationService;
        this.articleValidator = articleValidator;
    }

    @Override
    public ArticleDTO findArticleById(Integer id) throws ServiceException {
        try {
            return this.articleMapper.toDTO(this.articleRepository.findById(id)
                    .orElseThrow(() -> new ServiceException(this.translationService.getMsg(ErrMsg.A002, ErrMsg.IT))));
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<ArticleDTO> getAllArticles() throws ServiceException {
        try {
            return this.articleRepository.findAll().stream().map(articleMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<ArticleDTO> getArticlesByFilter(ArticleFilter articleFilter) throws ServiceException {
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
                result = result.stream().filter(a -> a.getPrice() > articleFilter.getMinPrice()).collect(Collectors.toList());
            if (articleFilter.getMaxPrice() != null)
                result = result.stream().filter(a -> a.getPrice() < articleFilter.getMaxPrice()).collect(Collectors.toList());

            return result.stream().map(articleMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<ArticleDTO> getArticlesByCategory(String category) throws ServiceException {
        try {
            return this.articleRepository.findByCategory(category).stream().map(this.articleMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    @Override
    public ArticleDTO addArticle(ArticleDTO articleDTO) throws ServiceException {
        try {
            Article toSave = this.articleMapper.toEntity(articleDTO);
            // validation
            this.articleValidator.validateCategory(toSave);
            // other validations TODO
            //
            //saving
            return this.articleMapper.toDTO(this.articleRepository.save(toSave));
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    @Override
    public void deleteArticle(Integer id) throws ServiceException {
        try {
            this.articleRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }
}
