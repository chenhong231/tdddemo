package com.chapter10;

import java.util.*;
import java.util.stream.Collectors;

public class MovieList {

    private List<Movie> movieList = new ArrayList<>();

    public int size() {
        return movieList.size();
    }

    public void add(Movie movie) {
        if(contains(movie)) {
            throw new DuplicateMovieException(movie.getName());
        }
        movieList.add(movie);
    }

    public boolean contains(Movie movie) {
        return movieList.contains(movie);
    }

    public void rename(Movie movie, String newName) {
        Movie potentialMovie = new Movie(movie);
        potentialMovie.rename(newName);
        if(contains(potentialMovie)) {
            throw new DuplicateMovieException(newName);
        }
        movie.rename(newName);
    }

    public MovieList categorySublist(String category) {
        final List<Movie> movies = movieList.stream().filter(c -> c.getCategory().equals(category))
                .collect(Collectors.toList());

        MovieList movieList = new MovieList();
        for(Movie movie : movies) {
            movieList.add(movie);
        }

        return movieList;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "movieList=" + movieList +
                '}';
    }

    public void sortUsing(Comparator comparator) {
        Collections.sort(movieList, comparator);
    }

    public Iterator iterator() {
        return movieList.iterator();
    }
}
