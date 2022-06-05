package com.refactoring.chapter6.before;

public class RemoveAssignmentsToParameters {

    void discount(int inputVal, int quantity, int yearToDate) {
        if(inputVal > 50) {
            inputVal -= 2;
        }
    }

    private int discount1(int inputVal, int quantity, int yearToDate) {
        if(inputVal > 50) {
            inputVal -= 2;
        }

        if(quantity > 100) {
            inputVal -= 1;
        }

        if(yearToDate > 10000) {
            inputVal -= 4;
        }

        return inputVal;
    }
}
