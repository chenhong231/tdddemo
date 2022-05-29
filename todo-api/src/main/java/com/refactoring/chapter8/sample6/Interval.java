package com.refactoring.chapter8.sample6;

import java.util.Observable;

public class Interval extends Observable {

    private String _end = "0";

    String getEnd() {
        return _end;
    }

    void setEnd(String arg) {
        _end = arg;
        setChanged();
        notifyObservers();
    }

}
