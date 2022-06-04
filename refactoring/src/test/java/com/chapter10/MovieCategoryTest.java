package com.chapter10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieCategoryTest {

    private Movie starWars;

    @BeforeEach
    public void setUp() {
        starWars = new Movie("Star Wars");
    }

    @Test
    public void should_getUncategorized_when_movie_is_not_set_category() {
        assertThat(starWars.getCategory()).isEqualTo(Movie.UNCATEGORIZED);
    }

    @Test
    public void should_get_category_when_movie_category_is_set() {
        String category = "Science Fiction";
        Movie alien = new Movie("Alien", category);
        assertThat(alien.getCategory()).isEqualTo(category);
    }
}
