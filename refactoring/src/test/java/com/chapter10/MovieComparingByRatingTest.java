package com.chapter10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieComparingByRatingTest {

    private MovieRatingComparator comparatorToTest = null;
    private Movie starTrek = null;

    @BeforeEach
    public void setUp() {
        comparatorToTest = new MovieRatingComparator();
        starTrek = new Movie("Star Trek", 3, Movie.SCIFI);
    }

    @Test
    public void should_return_0_when_movies_are_same() {
        Movie anotherStarTrek = new Movie("Star Trek", 3, Movie.SCIFI);
        assertThat(comparatorToTest.compare(starTrek, anotherStarTrek)).isEqualTo(0);
    }

    @Test
    public void should_return_negative_when_first_movie_rating_is_lower() {
        Movie alien = new Movie("Alien", 5, Movie.SCIFI);
        assertThat(comparatorToTest.compare(alien, starTrek) < 0).isTrue();
    }

    @Test
    public void should_return_positive_when_first_movie_rating_is_higher() {
        Movie starshipTroopers = new Movie("Starship troopers", 1, Movie.SCIFI);
        assertThat(comparatorToTest.compare(starshipTroopers, starTrek) > 0).isTrue();
    }

    @Test
    public void should_return_positive_when_first_movie_is_unrated() {
        Movie jurassicPark = new Movie("Jurassic Park", -1, Movie.SCIFI);
        assertThat(comparatorToTest.compare(jurassicPark, starTrek) > 0).isTrue();
    }
}
