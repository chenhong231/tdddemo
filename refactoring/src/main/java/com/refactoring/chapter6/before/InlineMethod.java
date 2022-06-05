package com.refactoring.chapter6.before;

public class InlineMethod {

    private int numberOfLateDeliveries;

    int getRating() {
        return (moreThanFiveLateDeliveries()) ? 2 : 1;
    }

    private boolean moreThanFiveLateDeliveries() {
        return numberOfLateDeliveries > 5;
    }

}
