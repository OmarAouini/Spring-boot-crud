package com.aouin.springbootcrud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private Integer id;
    private String email;
    private String username;
    private String password;
}
