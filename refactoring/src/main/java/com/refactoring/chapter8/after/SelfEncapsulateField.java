package com.refactoring.chapter8.after;

public class SelfEncapsulateField {

    private int low, high;

    boolean includes(int arg) {
        return arg >= getLow() && arg <= getHigh();
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
}
