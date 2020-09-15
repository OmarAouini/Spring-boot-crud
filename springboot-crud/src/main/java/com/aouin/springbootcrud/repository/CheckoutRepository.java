package com.aouin.springbootcrud.repository;

import com.aouin.springbootcrud.model.Checkout;
import io.swagger.models.auth.In;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckoutRepository extends MongoRepository<Checkout, Integer> {
    List<Checkout> findByUserId(Integer id);
}
