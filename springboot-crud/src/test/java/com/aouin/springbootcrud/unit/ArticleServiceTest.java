package com.aouin.springbootcrud.unit;

import com.aouin.springbootcrud.repository.ArticleRepository;
import com.aouin.springbootcrud.service.impl.ArticleServiceImpl;
import com.aouin.springbootcrud.service.mapper.ArticleMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("unit_article")
public class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ArticleServiceImpl articleService;

    @Spy
    private ArticleMapper articleMapper;


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
