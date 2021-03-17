package com.aouin.springbootcrud.service.dto;

import com.aouin.springbootcrud.model.ManufactureDetails;
import com.aouin.springbootcrud.model.ShippingDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

    private Integer id;
    private String name;
    private Float price;
    private String description;
    private List<String> categories;
    private ManufactureDetails manufactureDetails;
    private ShippingDetails shippingDetails;
    private Integer stockQuantity;
    private boolean isAvaliable;
}
