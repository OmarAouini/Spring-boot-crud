package com.aouin.springbootcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
