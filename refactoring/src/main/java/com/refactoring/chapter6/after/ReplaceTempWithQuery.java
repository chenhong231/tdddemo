package com.refactoring.chapter6.after;

public class ReplaceTempWithQuery {

    private int quantity;
    private double itemPrice;

    private double method() {
        if(getBasePrice() > 1000) {
            return getBasePrice() * 0.95;
        } else {
            return getBasePrice() * 0.98;
        }
    }

    private double getBasePrice() {
        double basePrice = quantity * itemPrice;
        return basePrice;
    }
}
