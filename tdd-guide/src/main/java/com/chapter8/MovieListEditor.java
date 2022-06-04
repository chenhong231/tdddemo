package com.chapter8;

import java.util.List;

public interface MovieListEditor {

    List getMovies();
    void add(String name);
    void delete(int index);
}
