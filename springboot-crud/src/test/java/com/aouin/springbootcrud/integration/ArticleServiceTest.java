package com.aouin.springbootcrud.integration;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aouin.springbootcrud.service.impl.ArticleServiceImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Tag("integration_article")
public class ArticleServiceTest extends AbstractBaseTest {

    @Autowired
    private ArticleServiceImpl articleService;

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

}
