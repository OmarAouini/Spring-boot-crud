package com.aouin.springbootcrud.repository;

import com.aouin.springbootcrud.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<Article, Integer> {
}
