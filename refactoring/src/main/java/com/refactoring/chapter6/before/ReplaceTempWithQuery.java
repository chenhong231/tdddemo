package com.refactoring.chapter6.before;

public class ReplaceTempWithQuery {

    private int quantity;
    private double itemPrice;

    private double method() {
        double basePrice = quantity * itemPrice;
        if(basePrice > 1000) {
            return basePrice * 0.95;
        } else {
            return basePrice * 0.98;
        }
    }
}
