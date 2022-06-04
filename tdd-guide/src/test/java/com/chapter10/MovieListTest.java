package com.chapter10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieListTest {
    private MovieList movieList;
    private Movie starWars;
    private Movie starTrek;

    @BeforeEach
    public void setUp() {
        movieList = new MovieList();
        starWars = new Movie("star wars");
        starTrek = new Movie("star trek");
    }

    @Test
    public void should_be_empty() {
        assertThat(movieList.size()).isEqualTo(0);
    }

    @Test
    public void shoud_add_movie() {
        movieList.add(starWars);
        assertThat(movieList.size()).isEqualTo(1);
    }

    @Test
    public void should_be_two_size_when_adding_two_movie() {
        movieList.add(starTrek);
        movieList.add(starWars);

        assertThat(movieList.size()).isEqualTo(2);
    }

    @Test
    public void should_return_true_when_movie_was_existed() {
        movieList.add(starWars);
        assertThat(movieList.contains(starWars)).isTrue();
    }

    @Test
    public void should_return_false_when_movie_was_not_existed() {
        movieList.add(starWars);
        assertThat(movieList.contains(starTrek)).isFalse();
    }
}
