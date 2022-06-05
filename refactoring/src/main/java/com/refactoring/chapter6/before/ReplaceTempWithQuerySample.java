package com.refactoring.chapter6.before;

public class ReplaceTempWithQuerySample {

    private int itemPrice;
    private int quantity;

    double getPrice() {
        int basePrice = quantity * itemPrice;
        double discountFactor;

        if(basePrice > 1000) {
            discountFactor = 0.95;
        } else {
            discountFactor = 0.98;
        }

        return basePrice * discountFactor;
    }
}
