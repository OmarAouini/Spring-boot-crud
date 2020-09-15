package com.aouin.springbootcrud.controller;

import com.aouin.springbootcrud.service.UserService;
import com.aouin.springbootcrud.service.dto.UserDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id")
    public ResponseEntity<UserDTO> getUserById(@RequestParam Integer id) throws ServiceException {
        return new ResponseEntity<>(this.userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/is-username-used")
    public ResponseEntity<Boolean> isUsernameAlreadyUsed(@RequestParam String username) throws ServiceException {
        return new ResponseEntity<>(this.userService.isUsernameAlreadyUsed(username), HttpStatus.OK);
    }

    @GetMapping("/is-email-used")
    public ResponseEntity<Boolean> isEmailAlreadyUsed(@RequestParam String email) throws ServiceException {
        return new ResponseEntity<>(this.userService.isEmailAlreadyUsed(email), HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user) {
        return new ResponseEntity<>(this.userService.addUser(user), HttpStatus.CREATED);
    }
}
