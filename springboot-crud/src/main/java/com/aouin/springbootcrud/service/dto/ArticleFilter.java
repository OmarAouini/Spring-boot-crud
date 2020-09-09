package com.aouin.springbootcrud.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleFilter {

    private Integer id;
    private String name;
    private Float price;
    private Float minPrice;
    private Float maxPrice;
    private List<String> categories;
}
