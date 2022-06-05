package com.refactoring.chapter6.after;

public class ReplaceMethodWithMethodObject {

    void gamma(int inputVal, int quantity, int yearToDate) {
        new Gamma(this, inputVal, quantity, yearToDate).compute();
    }

    public int delta() {
        return 0;
    }
}
