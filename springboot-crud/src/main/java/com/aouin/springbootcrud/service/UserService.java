package com.aouin.springbootcrud.service;

import com.aouin.springbootcrud.service.dto.UserDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;


public interface UserService {

    UserDTO findUserById(Integer id) throws ServiceException;
}
