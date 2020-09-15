package com.aouin.springbootcrud.service.impl;

import com.aouin.springbootcrud.repository.UserRepository;
import com.aouin.springbootcrud.service.UserService;
import com.aouin.springbootcrud.service.dto.UserDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;
import com.aouin.springbootcrud.service.mapper.UserMapper;
import com.aouin.springbootcrud.service.utils.ErrMsg;
import com.aouin.springbootcrud.service.utils.TranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TranslationService translationService;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, TranslationService translationService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.translationService = translationService;
    }

    @Override
    public UserDTO findUserById(Integer id) throws ServiceException {
        try {
            return this.userMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new Exception(this.translationService.getMsg(ErrMsg.U001, "en"))));
        } catch (Exception e) {
            throw new ServiceException(e.getLocalizedMessage());
        }
    }
}