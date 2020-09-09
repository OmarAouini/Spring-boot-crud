package com.aouin.springbootcrud.model;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "checkouts")
public class Checkout {

    private Integer transactionId;
    private Integer userId;
    private LocalDateTime date;
    private Shipping shipping;
    private Payment payment;
    private List<Article> articles;
}
