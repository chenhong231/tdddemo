package com.chapter10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieSortingByNameTest {

    private MovieNameComparator comparator;
    private List<Movie> sortedMovies;

    private MovieList sortedList;
    private MovieList reversedList;

    @BeforeEach
    public void setUp() {
        comparator = new MovieNameComparator();
        sortedMovies = new ArrayList<>();


        sortedMovies.add(new Movie("A", 5, Movie.SCIFI));
        sortedMovies.add(new Movie("B", 4, Movie.SCIFI));
        sortedMovies.add(new Movie("C", 3, Movie.SCIFI));
        sortedMovies.add(new Movie("D", 2, Movie.SCIFI));
        sortedMovies.add(new Movie("E", 1, Movie.SCIFI));
        sortedMovies.add(new Movie("F", 0, Movie.SCIFI));
        sortedMovies.add(new Movie("G", -1, Movie.SCIFI));

        sortedList = new MovieList();

        reversedList = new MovieList();
    }

    @Test
    public void should_sort_empty_list() {
        MovieList emptyList = new MovieList();
        emptyList.sortUsing(comparator);
        assertThat(emptyList.size()).isEqualTo(0);
    }

    @Test
    public void should_sorting_list_by_name() {
        for(Movie movie : sortedMovies) {
            sortedList.add(movie);
        }

        sortedList.sortUsing(comparator);

        assertThat(sortedMovies.size()).isEqualTo(sortedMovies.size());

        Iterator original = sortedMovies.iterator();
        Iterator sorted = sortedList.iterator();

        while (original.hasNext()) {
            assertThat(original.next()).isEqualTo(sorted.next());
        }
    }

    @Test
    public void should_sorting_reverse_by_name() {
        reversedList.sortUsing(comparator);

        Iterator original = sortedMovies.iterator();
        Iterator sorted = reversedList.iterator();
    }
}
