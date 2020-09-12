package com.aouin.springbootcrud.service.utils.validators;

import com.aouin.springbootcrud.service.dto.UserDTO;
import com.aouin.springbootcrud.service.utils.TranslationService;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {


    private TranslationService translationService;

    public UserValidator(TranslationService translationService) {
        this.translationService = translationService;
    }

    public void validateUser(UserDTO userDTO) {

    }
}
