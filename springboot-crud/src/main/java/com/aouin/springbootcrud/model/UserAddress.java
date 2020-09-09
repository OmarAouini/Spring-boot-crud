package com.aouin.springbootcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddress {

    private String address;
    private String city;
    private String region;
    private String state;
    private String country;
}
