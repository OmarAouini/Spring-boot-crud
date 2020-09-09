package com.aouin.springbootcrud.controller;

import com.aouin.springbootcrud.service.UserService;
import com.aouin.springbootcrud.service.dto.UserDTO;
import com.aouin.springbootcrud.service.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id")
    public ResponseEntity<UserDTO> getUserById(@RequestParam Integer id) throws ServiceException {
        return new ResponseEntity<>(this.userService.findUserById(id), HttpStatus.OK);
    }
}
