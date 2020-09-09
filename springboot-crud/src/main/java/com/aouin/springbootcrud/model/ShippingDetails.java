package com.aouin.springbootcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShippingDetails {
    private Float weight;
    private Float width;
    private Float height;
    private Float depth;
}
