package com.refactoring.chapter6.after;

public class IntroduceExplainingVariableSample {
    int quantity;
    double itemPrice;

    double price() {
        return getBasePrice() - getQuantityDiscount() + getShipping();
    }

    private double getShipping() {
        return Math.min(getBasePrice() * 0.1, 100.0);
    }

    private double getQuantityDiscount() {
        return Math.max(0, quantity - 500) * itemPrice * 0.05;
    }

    private double getBasePrice() {
        return quantity * itemPrice;
    }
}
