package com.chapter10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieComparingByNameTest {

    @Test
    public void should_return_0_when_movie_have_same_name() {
        Movie startTrek = new Movie("Star Trek", 3, Movie.SCIFI);
        Movie anotherStarTrek = new Movie("Star Trek", 3, Movie.SCIFI);
        MovieNameComparator comparatorToTest = new MovieNameComparator();
        assertThat(comparatorToTest.compare(startTrek, anotherStarTrek)).isEqualTo(0);
    }

    @Test
    public void should_return_negative_when_first_movie_name_is_before() {
        Movie starTrek = new Movie("Star Trek", 3, Movie.SCIFI);
        Movie alien = new Movie("Alien", 5, Movie.SCIFI);

        MovieNameComparator comparator = new MovieNameComparator();
        assertThat(comparator.compare(alien, starTrek) < 0).isTrue();
    }

    @Test
    public void should_return_positive_when_first_movie_name_is_after() {
        Movie starTrek = new Movie("Star Trek", 3, Movie.SCIFI);
        Movie startWars = new Movie("Star Wars", 4, Movie.SCIFI);

        MovieNameComparator comparator = new MovieNameComparator();
        assertThat(comparator.compare(startWars, starTrek) > 0).isTrue();
    }
}
