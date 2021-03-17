package com.aouin.springbootcrud.repository;

import java.util.List;

import com.aouin.springbootcrud.model.Checkout;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends MongoRepository<Checkout, Integer> {
    List<Checkout> findByUserId(Integer id);
}
