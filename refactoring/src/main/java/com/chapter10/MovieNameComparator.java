package com.chapter10;

import java.util.Comparator;

public class MovieNameComparator implements Comparator<Movie> {

    public MovieNameComparator() {
        super();
    }

    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie1.getName().compareTo(movie2.getName());
    }
}
