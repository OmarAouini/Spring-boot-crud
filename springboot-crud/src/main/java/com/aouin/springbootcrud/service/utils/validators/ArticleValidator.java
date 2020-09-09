package com.aouin.springbootcrud.service.utils.validators;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.model.enums.Category;

import java.util.Arrays;

public class ArticleValidator {

    public static void validateCategory(Article article) throws Exception {
        try {
            if (Arrays.stream(Category.values()).noneMatch(category -> category.toString().equalsIgnoreCase(article.getCategory())))
                throw new Exception("categoria sconosciuta");
        } catch (Exception e) {
            throw new Exception(e.getLocalizedMessage());
        }
    }
}
