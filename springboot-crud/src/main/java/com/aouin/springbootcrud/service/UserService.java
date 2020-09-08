package com.aouin.springbootcrud.service;

import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.dto.UserDTO;


public interface UserService {

    UserDTO findUserById(Integer id) throws Exception;
}
