package com.aouin.springbootcrud.repository;

import java.util.Optional;

import com.aouin.springbootcrud.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}