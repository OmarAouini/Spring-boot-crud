package com.aouin.springbootcrud.service.mapper;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.model.User;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);
}
