package com.refactoring.chapter6.sample2;

public class InlineMethod {

    private int _numberOfLateDeliveries;

    int getRating() {
        return (_numberOfLateDeliveries > 5) ? 2 : 1;
    }
}
