package com.refactoring.chapter8.after;

import java.util.Observable;

public class Interval extends Observable {
    private String start = "0";
    private String end = "0";
    private String length = "0";

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
        setChanged();
        notifyObservers();
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
        setChanged();
        notifyObservers();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
        setChanged();
        notifyObservers();
    }

    public void calculateLength() {
        try {
            int start = Integer.parseInt(getStart());
            int end = Integer.parseInt(getEnd());
            int length = end - start;
            setLength(String.valueOf(length));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unexpected Number Format Error");
        }
    }

    public void calculateEnd() {
        try {
            int start = Integer.parseInt(getStart());
            int length = Integer.parseInt(getLength());
            int end = start + length;
            setEnd(String.valueOf(end));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Unexpected Number Format Error");
        }
    }
}
