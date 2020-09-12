package com.aouin.springbootcrud.repository;

import com.aouin.springbootcrud.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends MongoRepository<Article, Integer> {
    List<Article> findByCategoriesIn(List<String> categories);
}
