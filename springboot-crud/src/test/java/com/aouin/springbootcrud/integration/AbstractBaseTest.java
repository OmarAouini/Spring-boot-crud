package com.aouin.springbootcrud.integration;

import com.aouin.springbootcrud.repository.ArticleRepository;
import com.aouin.springbootcrud.repository.CheckoutRepository;
import com.aouin.springbootcrud.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@SpringBootTest
public abstract class AbstractBaseTest {

    @MockBean(answer = Answers.RETURNS_SMART_NULLS)
    private UserRepository userRepository;

    @MockBean(answer = Answers.RETURNS_SMART_NULLS)
    private ArticleRepository articleRepository;

    @MockBean(answer = Answers.RETURNS_SMART_NULLS)
    private CheckoutRepository checkoutRepository;
}
