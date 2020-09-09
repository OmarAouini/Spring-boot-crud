package com.aouin.springbootcrud.integration;

import com.aouin.springbootcrud.repository.ArticleRepository;
import com.aouin.springbootcrud.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@SpringBootTest
public abstract class AbstractBaseTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ArticleRepository articleRepository;
}
