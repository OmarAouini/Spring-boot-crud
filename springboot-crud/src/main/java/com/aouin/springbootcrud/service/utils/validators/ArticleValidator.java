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

    public void validateCategory(Article article) throws ServiceException {
        try {
            if (Arrays.stream(Category.values()).noneMatch(category -> category.toString().equalsIgnoreCase(article.getCategory())))
                throw new ServiceException(this.translationService.getMsg(ErrMsg.A003, ErrMsg.IT));
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }
}
