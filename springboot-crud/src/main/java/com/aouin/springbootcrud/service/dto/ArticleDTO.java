package com.aouin.springbootcrud.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

    private Integer id;

    private String name;
    private Float price;
    private String description;
    private String category;
}
