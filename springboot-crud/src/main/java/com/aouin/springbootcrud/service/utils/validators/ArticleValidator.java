package com.aouin.springbootcrud.service.utils.validators;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.model.enums.Category;
import com.aouin.springbootcrud.service.exceptions.ArticleValidationException;
import com.aouin.springbootcrud.service.utils.ErrMsg;
import com.aouin.springbootcrud.service.utils.TranslationService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ArticleValidator {

    private final TranslationService translationService;

    public ArticleValidator(TranslationService translationService) {
        this.translationService = translationService;
    }

    public void validateArticle(Article article) throws ArticleValidationException {
        try {
            this.validateArticleName(article);
            this.validateArticlePrice(article);
            this.validateArticleCategory(article);
            this.validateManufactureDetails(article);
            this.validateShippingDetails(article);
            this.validateStockQuantity(article);
        } catch (ArticleValidationException e) {
            throw new ArticleValidationException(e.getLocalizedMessage());
        }
    }


    private void validateArticleCategory(Article article) throws ArticleValidationException {

        if (article.getCategories() != null && !article.getCategories().isEmpty()) {

            for (String category : article.getCategories()) {
                if (Arrays.stream(Category.values()).noneMatch(c -> c.toString().equalsIgnoreCase(category.toUpperCase())))
                    throw new ArticleValidationException(this.translationService.getMsg(ErrMsg.A003, ErrMsg.IT));
            }
        } else
            throw new ArticleValidationException(this.translationService.getMsg(ErrMsg.A006, ErrMsg.IT));
    }

    private void validateArticlePrice(Article article) throws ArticleValidationException {
        if (article.getPrice() != null && article.getPrice() < 0.0F)
            throw new ArticleValidationException(this.translationService.getMsg(ErrMsg.A004, ErrMsg.IT));
    }

    private void validateArticleName(Article article) throws ArticleValidationException {
        if (article.getName() == null || article.getName().isEmpty())
            throw new ArticleValidationException(this.translationService.getMsg(ErrMsg.A005, ErrMsg.IT));
    }

    private void validateShippingDetails(Article article) throws ArticleValidationException {
        if (article.getShippingDetails().getDepth() == null || article.getShippingDetails().getDepth() < 0.0F ||
                article.getShippingDetails().getHeight() == null || article.getShippingDetails().getHeight() < 0.0F ||
                article.getShippingDetails().getWeight() == null || article.getShippingDetails().getWeight() < 0.0F ||
                article.getShippingDetails().getWidth() == null || article.getShippingDetails().getWidth() < 0.0F)
            throw new ArticleValidationException(this.translationService.getMsg(ErrMsg.A008, ErrMsg.IT));
    }

    private void validateManufactureDetails(Article article) throws ArticleValidationException {
        if (article.getManufactureDetails().getManufactorName() == null || article.getManufactureDetails().getManufactorName().isEmpty() ||
                article.getManufactureDetails().getModelNumber() == null || article.getManufactureDetails().getModelNumber().isEmpty() ||
                article.getManufactureDetails().getReleaseDate() == null || article.getManufactureDetails().getReleaseDate().isEmpty())
            throw new ArticleValidationException(this.translationService.getMsg(ErrMsg.A009, ErrMsg.IT));
    }

    private void validateStockQuantity(Article article) throws ArticleValidationException {
        if (article.getStockQuantity() == null || article.getStockQuantity() < 0)
            throw new ArticleValidationException(this.translationService.getMsg(ErrMsg.A007, ErrMsg.IT));
    }
}
