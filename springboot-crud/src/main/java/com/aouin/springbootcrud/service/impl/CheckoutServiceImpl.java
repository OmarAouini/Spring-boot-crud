package com.aouin.springbootcrud.service.impl;

import com.aouin.springbootcrud.repository.ArticleRepository;
import com.aouin.springbootcrud.repository.CheckoutRepository;
import com.aouin.springbootcrud.repository.UserRepository;
import com.aouin.springbootcrud.service.CheckoutService;
import com.aouin.springbootcrud.service.dto.CheckoutDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;
import com.aouin.springbootcrud.service.mapper.CheckoutMapper;
import com.aouin.springbootcrud.service.utils.ErrMsg;
import com.aouin.springbootcrud.service.utils.TranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CheckoutServiceImpl implements CheckoutService {

    private UserRepository userRepository;
    private ArticleRepository articleRepository;
    private CheckoutMapper checkoutMapper;
    private CheckoutRepository checkoutRepository;
    private TranslationService translationService;

    public CheckoutServiceImpl(UserRepository userRepository, ArticleRepository articleRepository, CheckoutMapper checkoutMapper, CheckoutRepository checkoutRepository, TranslationService translationService) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.checkoutRepository = checkoutRepository;
        this.checkoutMapper = checkoutMapper;
        this.translationService = translationService;
    }

    @Override
    public List<CheckoutDTO> getAllCheckOuts() {
        return this.checkoutRepository.findAll().stream().map(checkoutMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<CheckoutDTO> getCheckoutsByUserId(Integer id) {
        return this.checkoutRepository.findByUserId(id).stream().map(checkoutMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CheckoutDTO getCheckoutById(Integer id) throws ServiceException {
        return this.checkoutMapper.toDTO(this.checkoutRepository.findById(id).orElseThrow(() -> new ServiceException(this.translationService.getMsg(ErrMsg.C001, "en"))));
    }


}
