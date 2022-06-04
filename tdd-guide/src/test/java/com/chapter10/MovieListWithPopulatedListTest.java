package com.chapter10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MovieListWithPopulatedListTest {

    private MovieList movieList = null;
    private Movie starWars = null;
    private Movie starTrek = null;
    private Movie stargate = null;

    @BeforeEach
    public void setUp() {
        stargate = new Movie("Stargate");
        starWars = new Movie("Star Wars");
        starTrek = new Movie("Star Trek");

        movieList = new MovieList();
        movieList.add(starWars);
        movieList.add(stargate);
        movieList.add(starTrek);
    }

    @Test
    public void should_throw_duplicated_exception_when_duplicate_movie_is_added() {
        Movie movie = new Movie(starWars.getName());
        assertThatExceptionOfType(DuplicateMovieException.class)
                .isThrownBy(()->movieList.add(movie));
    }

    @Test
    public void should_rename_movie() {
        String newName = "StarTrek I";
        movieList.rename(starTrek, newName);
        assertThat(starTrek.getName()).isEqualTo(newName);
    }

    @Test
    public void should_throw_duplicate_exception_when_move_is_renamed_as_existed_movie_name() {
        assertThatExceptionOfType(DuplicateMovieException.class)
                .isThrownBy(() -> movieList.rename(starTrek, starWars.getName()));
    }
}
