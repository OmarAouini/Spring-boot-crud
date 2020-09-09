package com.aouin.springbootcrud.integration;

import com.aouin.springbootcrud.repository.UserRepository;
import com.aouin.springbootcrud.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Tag;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

@Tag("integration_user")
public class UserServiceTest extends AbstractBaseTest {

    @Autowired
    private UserServiceImpl userService;
}
