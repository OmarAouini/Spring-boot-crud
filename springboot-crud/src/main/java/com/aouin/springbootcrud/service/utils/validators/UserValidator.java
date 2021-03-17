package com.aouin.springbootcrud.service.utils.validators;

import com.aouin.springbootcrud.model.User;
import com.aouin.springbootcrud.model.enums.UserRole;
import com.aouin.springbootcrud.service.exceptions.UserValidationException;
import com.aouin.springbootcrud.service.utils.ErrMsg;
import com.aouin.springbootcrud.service.utils.TranslationService;
import org.springframework.stereotype.Component;
import static com.aouin.springbootcrud.service.utils.Utils.*;

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
        if (user.getUserAddresses().stream()
                .anyMatch(address -> address == null || isNullOrEmptyString(address.getAddress())
                        || isNullOrEmptyString(address.getCity()) || isNullOrEmptyString(address.getCountry())
                        || isNullOrEmptyString(address.getRegion()) || isNullOrEmptyString(address.getState()))
            )
            throw new UserValidationException(this.translationService.getMsg(ErrMsg.U003, ErrMsg.IT));
    }

    // pswd minimo 8 caratteri e deve contenere caratteri speciali
    private void validatePassword(User user) throws UserValidationException {

        String pswd = user.getPassword();
        if (!isNullOrEmptyString(pswd) && pswd.length() >= 8) {

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

    // deve rispettare forma email
    private void validateEmail(User user) throws UserValidationException {
        if (!isNullOrEmptyString(user.getEmail())) {

            String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(user.getEmail());

            if (!matcher.matches()) {
                throw new UserValidationException(this.translationService.getMsg(ErrMsg.U007, ErrMsg.IT));
            }
        } else
            throw new UserValidationException(this.translationService.getMsg(ErrMsg.U006, ErrMsg.IT));
    }

    private void validateUsername(User user) throws UserValidationException {
        if (!isNullOrEmptyString(user.getUsername()) || user.getUsername().length() > 16)
            throw new UserValidationException(this.translationService.getMsg(ErrMsg.U008, ErrMsg.IT));
    }

}
