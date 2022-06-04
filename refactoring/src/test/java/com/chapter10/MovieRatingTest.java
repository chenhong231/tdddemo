package com.chapter10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MovieRatingTest {

    private Movie starWars;

    @BeforeEach
    public void setUp() {
        starWars = new Movie("Star Wars");
    }

    @Test
    public void should_return_false_when_movie_does_not_have_rating() {
        assertThat(starWars.hasRating()).isFalse();
    }

    @Test
    public void should_get_correct_rating_when_movie_has_rating() {
        Movie rating = new Movie("Fellowship of the Ring", 5);
        assertThat(rating.hasRating()).isTrue();
        assertThat(rating.getRating()).isEqualTo(5);
    }

    @Test
    public void should_throw_exception_when_trying_to_get_unrated_movie() {
        assertThatExceptionOfType(UnRatedException.class)
                .isThrownBy(() -> starWars.getRating());
    }
}
