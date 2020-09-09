package com.aouin.springbootcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipping {

    private Integer userId;
    private UserAddress userAddress;
    private ShippingDetails shippingDetails;
}
