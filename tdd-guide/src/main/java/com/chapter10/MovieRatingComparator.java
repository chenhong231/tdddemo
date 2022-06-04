package com.chapter10;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    public MovieRatingComparator() {
        super();
    }

    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie2.getRawRating() - movie1.getRawRating();
    }
}
