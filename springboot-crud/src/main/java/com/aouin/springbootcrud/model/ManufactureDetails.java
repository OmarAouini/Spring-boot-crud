package com.aouin.springbootcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManufactureDetails {
    private String manufactorName;
    private String modelNumber;
    private String releaseDate;
}
