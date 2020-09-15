package com.aouin.springbootcrud.service.utils.validators;

import com.aouin.springbootcrud.model.User;
import com.aouin.springbootcrud.model.enums.UserRole;
import com.aouin.springbootcrud.service.exceptions.UserValidationException;
import com.aouin.springbootcrud.service.utils.ErrMsg;
import com.aouin.springbootcrud.service.utils.TranslationService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator {


    private final TranslationService translationService;

    public UserValidator(TranslationService translationService) {
        this.translationService = translationService;
    }

    public void validateUser(User user) throws UserValidationException {
        this.validateUsername(user);
        this.validateEmail(user);
        this.validatePassword(user);
        this.validateAddresses(user);
        this.validateRoles(user);
    }

    private void validateRoles(User user) throws UserValidationException {
        if (Arrays.stream(UserRole.values()).noneMatch(userRole -> user.getRoles().contains(userRole.toString())))
            throw new UserValidationException(this.translationService.getMsg(ErrMsg.U002, ErrMsg.IT));
    }

    private void validateAddresses(User user) throws UserValidationException {
        if (user.getUserAddresses().stream().anyMatch(address -> address == null ||
                address.getAddress() == null || address.getAddress().isEmpty() ||
                address.getCity() == null || address.getCity().isEmpty() ||
                address.getCountry() == null || address.getCountry().isEmpty() ||
                address.getRegion() == null || address.getRegion().isEmpty() ||
                address.getState() == null || address.getState().isEmpty()))
            throw new UserValidationException(this.translationService.getMsg(ErrMsg.U003, ErrMsg.IT));
    }

    // pswd minimo 8 caratteri e deve contenere caratteri speciali
    private void validatePassword(User user) throws UserValidationException {

        String pswd = user.getPassword();
        if (pswd != null && !pswd.isEmpty() && pswd.length() >= 8) {

            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher hasLetter = letter.matcher(pswd);
            Matcher hasDigit = digit.matcher(pswd);
            Matcher hasSpecial = special.matcher(pswd);

            if (!hasLetter.find() || !hasDigit.find() || !hasSpecial.find())
                throw new UserValidationException(this.translationService.getMsg(ErrMsg.U004, ErrMsg.IT));

        } else
            throw new UserValidationException(this.translationService.getMsg(ErrMsg.U005, ErrMsg.IT));
    }

    private void validateEmail(User user) {
    }

    private void validateUsername(User user) {
    }
}
