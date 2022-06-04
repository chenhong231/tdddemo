package com.chapter10;

import org.springframework.util.StringUtils;

import java.util.Objects;

public class Movie {

    public static final String UNCATEGORIZED = "Uncategorized";
    public static final String SCIFI = "Science Fiction";
    public static final String HORROR = "Horror";
    public static final String FANTASY= "Fantasy";
    public static final String THRILLER = "Thriller";

    private String name;
    private int rating;
    private String category;

    public Movie(String name) {
        this(name, -1);
    }

    public Movie(Movie original) {
        name = original.name;
        rating = original.rating;
        category = original.category;
    }

    public Movie(String name, int rating) {
        this(name, rating, null);
    }

    public Movie(String name, String category) {
        this(name, -1, category);
        this.category = category;
    }

    public Movie(String name, int rating, String category) {
        if(!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("null Movie name");
        }
        checkCategory(category);

        this.name = name;
        this.rating = rating;
        this.category = category == null ? "Uncategorized" : category;
    }

    private void checkCategory(String category) {
        if(!StringUtils.hasText(category)) {
            return;
        }
        if(UNCATEGORIZED.equals(category)) {
            return;
        }

        if(SCIFI.equals(category)) {
            return;
        }

        if(HORROR.equals(category)) {
            return;
        }

        if(FANTASY.equals(category)) {
            return;
        }

        if(THRILLER.equals(category)) {
            return;
        }

        throw new IllegalArgumentException("Bad Category:" + category);
    }

    public int getRating() {
        if(!hasRating()) {
            throw new UnRatedException(name);
        }
        return rating;
    }

    public int getRawRating() {
        return rating;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void rename(String newName) {
        if(!StringUtils.hasText(newName)) {
            throw new IllegalArgumentException("null Movie name");
        }
        this.name = newName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean hasRating() {
        return rating > -1;
    }

    public String getCategory() {
        return this.category;
    }
}
