package com.aouin.springbootcrud.service;

import java.util.List;

import com.aouin.springbootcrud.service.dto.CheckoutDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;

public interface CheckoutService {

    List<CheckoutDTO> getAllCheckOuts();
    List<CheckoutDTO> getCheckoutsByUserId(Integer id);
    CheckoutDTO getCheckoutById(Integer id) throws ServiceException;
}
