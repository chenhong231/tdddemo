package com.chapter10;

import org.junit.jupiter.api.BeforeEach;

public class MovieSublistTest {

    private Movie starWars;
    private Movie starTrek;
    private Movie stargate;
    private Movie theShining;
    private Movie carrie;
    private Movie fotr;
    private Movie redOctober;
    private Movie congo;
    private Movie princessBride;

    private MovieList movieList;
    private MovieList fantasyList;

    @BeforeEach
    public void setUp() {
        starWars = new Movie("Star Wars",5,  Movie.SCIFI);
        starTrek = new Movie("Star Trek", 3, Movie.SCIFI);
        stargate = new Movie("Stargate", -1, Movie.SCIFI);

        theShining = new Movie("The Shining", 2, Movie.HORROR);
        carrie = new Movie("Carrie",3, Movie.HORROR);

        fotr = new Movie("The Fellowship of the Ring", 5, Movie.FANTASY);
        redOctober = new Movie("The Hunt For Red October", 3, Movie.THRILLER);
        congo = new Movie("Congo", 3, Movie.THRILLER);
        princessBride = new Movie("The Princess Bride", 5, Movie.FANTASY);

        movieList = new MovieList();
        movieList.add(starWars);
        movieList.add(starTrek);
        movieList.add(stargate);
        movieList.add(theShining);
        movieList.add(carrie);
        movieList.add(fotr);
        movieList.add(redOctober);
        movieList.add(congo);
        movieList.add(princessBride);

        fantasyList = new MovieList();
        fantasyList.add(fotr);
        fantasyList.add(princessBride);
    }

    //TODO:

//    @Test
//    public void should_get_the_same_sublist_when_given_category_is_set() {
//        final MovieList subList = movieList.categorySublist(Movie.FANTASY);
//
//        assertThat(subList).isEqualTo(fantasyList);
//    }
}
