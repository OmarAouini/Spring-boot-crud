package com.aouin.springbootcrud.service;

import com.aouin.springbootcrud.service.dto.UserDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;


public interface UserService {

    UserDTO findUserById(Integer id) throws ServiceException;
    boolean isEmailAlreadyUsed(String email) throws ServiceException;
    boolean isUsernameAlreadyUsed(String username) throws ServiceException;
    UserDTO addUser(UserDTO userDTO) throws ServiceException;
}
