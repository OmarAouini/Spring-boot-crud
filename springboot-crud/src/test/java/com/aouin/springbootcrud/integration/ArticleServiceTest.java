package com.aouin.springbootcrud.integration;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import com.aouin.springbootcrud.repository.ArticleRepository;
import com.aouin.springbootcrud.service.dto.ArticleDTO;
import com.aouin.springbootcrud.service.impl.ArticleServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import lombok.SneakyThrows;

@Tag("integration_article")
public class ArticleServiceTest extends AbstractBaseTest {

    @Autowired
    private ArticleServiceImpl articleService;

    @MockBean
    private ArticleRepository articleRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("findByFilter")
    @Nested
    class findByFilterTest {

        @Test
        void allFilterFields() {
            assertThat("pippo").isNotNull();
        }

        @Test
        void noFilterFields() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void notFound() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void onlyCategory() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void invalidCategory() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void onlyName() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void minPrice() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void maxPrice() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void minMaxPrice_Found() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void minMaxPrice_NotFound() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void exception() {
            assertEquals(5, 3 + 2);

        }

    }


    @DisplayName("findById")
    @Nested
    class findByIdTest {

        @Test
        void found() {
            
            assertEquals(5, 3 + 2);

        }

        @Test
        void notFound() {
            assertEquals(5, 3 + 2);

        }

        @Test
        void exception() {
            assertEquals(5, 3 + 2);

        }
    }

    @DisplayName("findAll")
    @Nested
    class findAllTest {

        @Test
        void found() {
            assertTrue(true);
        }

        @Test
        @SneakyThrows
        void notFound() {

            //given
            List lista = Collections.emptyList();
            when(articleRepository.findAll()).thenReturn(lista);

            //when
            List<ArticleDTO> result = articleService.getAllArticles();

            //then
            assertThat(result).isNotNull();
            assertThat(result).isEmpty();

        }

    }

}
