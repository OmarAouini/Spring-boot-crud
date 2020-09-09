package com.aouin.springbootcrud.service.dto;

import com.aouin.springbootcrud.model.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String id;
    private String email;
    private String username;
    private String password;
    private List<UserAddress> userAddresses;
}
