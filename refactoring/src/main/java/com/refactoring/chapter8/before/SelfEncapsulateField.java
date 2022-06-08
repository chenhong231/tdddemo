package com.refactoring.chapter8.before;

public class SelfEncapsulateField {

    private int low, high;

    boolean includes(int arg) {
        return arg >= low && arg <= high;
    }
}
