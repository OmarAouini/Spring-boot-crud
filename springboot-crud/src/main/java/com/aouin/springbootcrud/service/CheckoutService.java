package com.aouin.springbootcrud.service;

import com.aouin.springbootcrud.model.Checkout;
import com.aouin.springbootcrud.service.dto.CheckoutDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;

import java.util.List;

public interface CheckoutService {

    List<CheckoutDTO> getAllCheckOuts();
    List<CheckoutDTO> getCheckoutsByUserId(Integer id);
    CheckoutDTO getCheckoutById(Integer id) throws ServiceException;
}
