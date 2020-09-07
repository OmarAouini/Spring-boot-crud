package com.aouin.springbootcrud.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    private String id;
    private String email;
    private String username;
    private String password;
}
