package com.aouin.springbootcrud.service.utils.validators;

import com.aouin.springbootcrud.model.User;
import com.aouin.springbootcrud.service.utils.TranslationService;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {


    private final TranslationService translationService;

    public UserValidator(TranslationService translationService) {
        this.translationService = translationService;
    }

    public void validateUser(User user) {
        this.validateUsername(user);
        this.validateEmail(user);
        this.validatePassword(user);
        this.validateAddresses(user);
        this.validateRoles(user);
    }

    private void validateRoles(User user) {
    }

    private void validateAddresses(User user) {
    }

    private void validatePassword(User user) {
    }

    private void validateEmail(User user) {
    }

    private void validateUsername(User user) {
    }
}
