package com.aouin.springbootcrud.service.dto;

import com.aouin.springbootcrud.model.Article;
import com.aouin.springbootcrud.model.Payment;
import com.aouin.springbootcrud.model.Shipping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckoutDTO {

    private Integer transactionId;
    private Integer userId;
    private LocalDateTime date;
    private Shipping shipping;
    private Payment payment;
    private List<Article> articles;
}
