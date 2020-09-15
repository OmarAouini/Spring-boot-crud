package com.aouin.springbootcrud.service.mapper;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.model.Checkout;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.dto.CheckoutDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CheckoutMapper {

    Checkout toEntity(CheckoutDTO checkoutDTO);
    CheckoutDTO toDTO(Checkout checkout);
}
