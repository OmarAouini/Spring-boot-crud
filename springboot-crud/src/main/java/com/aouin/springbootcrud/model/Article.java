package com.aouin.springbootcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "articles")
public class Article {

    @Id
    private Integer id;
    private String name;
    private Float price;
    private String description;
    private List<String> categories;
    private ManufactureDetails manufactureDetails;
    private ShippingDetails shippingDetails;
    private Integer stockQuantity;
}
