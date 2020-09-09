package com.aouin.springbootcrud.service.utils.validators;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.model.enums.Category;
import com.aouin.springbootcrud.service.exceptions.ServiceException;
import com.aouin.springbootcrud.service.utils.ErrMsg;
import com.aouin.springbootcrud.service.utils.TranslationService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ArticleValidator {

    private TranslationService translationService;

    public ArticleValidator(TranslationService translationService) {
        this.translationService = translationService;
    }

    public void validateArticle(Article article) throws ServiceException {
        try {
            validateArticleName(article);
            validateArticlePrice(article);
            validateArticleCategory(article);
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    private void validateArticleCategory(Article article) throws ServiceException {
        if (article.getCategory() != null && Arrays.stream(Category.values()).noneMatch(category -> category.toString().equalsIgnoreCase(article.getCategory())))
            throw new ServiceException(this.translationService.getMsg(ErrMsg.A003, ErrMsg.IT));
    }

    private void validateArticlePrice(Article article) throws ServiceException {
        if (article.getPrice() != null && article.getPrice() < 0.0F)
            throw new ServiceException(this.translationService.getMsg(ErrMsg.A004, ErrMsg.IT));
    }

    private void validateArticleName(Article article) throws ServiceException {
        if (article.getName() == null || article.getName().equalsIgnoreCase(""))
            throw new ServiceException(this.translationService.getMsg(ErrMsg.A005, ErrMsg.IT));
    }
}
