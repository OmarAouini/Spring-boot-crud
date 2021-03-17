package com.aouin.springbootcrud.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "checkouts")
public class Checkout {

    @Id
    private Integer transactionId;
    private Integer userId;
    private LocalDateTime date;
    private Shipping shipping;
    private Payment payment;
    private List<Article> articles;
}
