package com.aouin.springbootcrud.integration;

import com.aouin.springbootcrud.repository.ArticleRepository;
import com.aouin.springbootcrud.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Tag("integration_article")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@SpringBootTest
public class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleServiceImpl articleService;


    @DisplayName("findByFilter")
    @Nested
    class findByFilterTest {

        @Test
        void allFilterFields() {

        }

        @Test
        void noFilterFields() {

        }

        @Test
        void notFound() {

        }

        @Test
        void onlyCategory() {

        }

        @Test
        void invalidCategory() {

        }

        @Test
        void onlyName() {

        }

        @Test
        void minPrice() {

        }

        @Test
        void maxPrice() {

        }

        @Test
        void minMaxPrice_NotFound() {

        }

        @Test
        void exception() {

        }

    }


    @DisplayName("findById")
    @Nested
    class findByIdTest {

        @Test
        void found() {

        }

        @Test
        void notFound() {

        }

        @Test
        void exception() {

        }
    }

}
