package com.aouin.springbootcrud.service.impl;

import com.aouin.springbootcrud.repository.UserRepository;
import com.aouin.springbootcrud.service.UserService;
import com.aouin.springbootcrud.service.dto.UserDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;
import com.aouin.springbootcrud.service.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO findUserById(Integer id) throws ServiceException {
        try {
            return this.userMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new Exception("id dell'utente non trovato!")));
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }
}