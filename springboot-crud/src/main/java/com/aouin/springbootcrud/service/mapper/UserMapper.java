package com.aouin.springbootcrud.service.mapper;

import com.aouin.springbootcrud.model.User;
import com.aouin.springbootcrud.service.dto.UserDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);
}
