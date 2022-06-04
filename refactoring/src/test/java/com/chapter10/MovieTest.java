package com.chapter10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MovieTest {

    private Movie starWars;

    @BeforeEach
    public void setUp() {
        starWars = new Movie("Star Wars");
    }

    @Test
    public void should_get_the_set_movie_name() {
        assertThat(starWars.getName()).isEqualTo("Star Wars");
    }

    @Test
    public void should_get_the_same_value_when_calling_toString_method() {
        assertThat(starWars.toString()).isEqualTo("Star Wars");
    }

    @Test
    public void should_get_newName_when_movie_is_renamed() {
        String newName = "Star Wars2";
        starWars.rename(newName);
        assertThat(starWars.getName()).isEqualTo(newName);
    }

    @Test
    public void should_throw_exception_when_movie_is_set_null_name() {
        String name = null;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->new Movie(name));
    }

    @Test
    public void should_throw_exception_when_movie_is_rename_as_null() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> starWars.rename(null));
    }

    @Test
    public void should_throw_exception_when_movie_is_rename_as_empty_string() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> starWars.rename(""));
    }

    @Test
    public void should_copy_by_constructor() {
        Movie copyOfStarWars = new Movie(starWars);
        assertThat(copyOfStarWars).isNotSameAs(starWars);
        assertThat(copyOfStarWars).isEqualTo(starWars);
    }

    @Test
    public void should_throw_exception_when_invalid_value_is_set() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Movie("Alien",-1, "SciFi"));
    }
}
