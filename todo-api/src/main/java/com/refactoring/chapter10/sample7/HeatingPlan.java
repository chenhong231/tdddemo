package com.refactoring.chapter10.sample7;

public class HeatingPlan {

    boolean withinRange (TempRange tempRange, int low, int high) {
        return (low >= _range.getLow() && high <= _range.getHigh());
    }
    private TempRange _range;
}
