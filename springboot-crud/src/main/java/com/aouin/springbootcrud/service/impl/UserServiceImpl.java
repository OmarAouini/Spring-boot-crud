package com.aouin.springbootcrud.service.impl;

import com.aouin.springbootcrud.repository.UserRepository;
import com.aouin.springbootcrud.service.UserService;
import com.aouin.springbootcrud.service.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findUserById(Integer id) {
        return null;
    }
}
