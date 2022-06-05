package com.refactoring.chapter6.after;

public class RemoveAssignmentsToParameters {

    void discount(int inputVal, int quantity, int yearToDate) {
        int result = inputVal;
        if(inputVal > 50) {
            result -= 2;
        }
    }

    private int discount1(final int inputVal, int quantity, int yearToDate) {
        int result = inputVal;
        if(inputVal > 50) {
            result -= 2;
        }

        if(quantity > 100) {
            result -= 1;
        }

        if(yearToDate > 10000) {
            result -= 4;
        }
        return result;
    }
}
