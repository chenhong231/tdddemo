package com.refactoring.chapter6.after;

public class ReplaceTempWithQuerySample {

    private int itemPrice;
    private int quantity;

    double getPrice() {
        return getBasePrice() * getDiscountFactor();
    }

    private double getDiscountFactor() {
        if(getBasePrice() > 1000) {
            return  0.95;
        } else {
            return  0.98;
        }
    }

    private int getBasePrice() {
        return quantity * itemPrice;
    }
}
