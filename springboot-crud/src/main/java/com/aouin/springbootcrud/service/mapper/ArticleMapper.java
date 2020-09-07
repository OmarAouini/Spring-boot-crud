package com.aouin.springbootcrud.service.mapper;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ArticleMapper {

    Article toEntity(ArticleDTO articleDTO);
    ArticleDTO toDTO(Article article);
}
