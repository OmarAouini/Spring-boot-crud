package com.aouin.springbootcrud.service.impl;

import com.aouin.springbootcrud.model.User;
import com.aouin.springbootcrud.repository.UserRepository;
import com.aouin.springbootcrud.service.UserService;
import com.aouin.springbootcrud.service.dto.UserDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;
import com.aouin.springbootcrud.service.exceptions.UserValidationException;
import com.aouin.springbootcrud.service.mapper.UserMapper;
import com.aouin.springbootcrud.service.utils.ErrMsg;
import com.aouin.springbootcrud.service.utils.TranslationService;
import com.aouin.springbootcrud.service.utils.validators.UserValidator;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TranslationService translationService;
    private UserValidator userValidator;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, TranslationService translationService, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.translationService = translationService;
        this.userValidator = userValidator;
    }

    @Override
    public UserDTO findUserById(Integer id) throws ServiceException {
        try {
            return this.userMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new Exception(this.translationService.getMsg(ErrMsg.U001, "en"))));
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    @Override
    public boolean isEmailAlreadyUsed(String email) throws ServiceException {
        try {
            return this.userRepository.exists(Example.of(User.builder().email(email).build()));
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    @Override
    public boolean isUsernameAlreadyUsed(String username) throws ServiceException {
        try {
            return this.userRepository.exists(Example.of(User.builder().username(username).build()));
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) throws ServiceException {
        try {
            User user = this.userMapper.toEntity(userDTO);
            //validation
            this.userValidator.validateUser(user);
            //saving
            return this.userMapper.toDTO(this.userRepository.save(user));
        } catch (Exception | UserValidationException e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }
}