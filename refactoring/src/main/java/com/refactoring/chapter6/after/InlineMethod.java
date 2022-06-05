package com.refactoring.chapter6.after;

public class InlineMethod {

    private int numberOfLateDeliveries;

    int getRating() {
        return (numberOfLateDeliveries > 5) ? 2 : 1;
    }

}
