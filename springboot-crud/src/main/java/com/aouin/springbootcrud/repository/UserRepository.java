package com.aouin.springbootcrud.repository;

import com.aouin.springbootcrud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    User findByUsername(String username);
}