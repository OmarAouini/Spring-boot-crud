package com.aouin.springbootcrud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articles")
public class Article {

    @Id
    private Integer id;

    private String name;
    private Float price;
    private String description;
    private String category;
}
