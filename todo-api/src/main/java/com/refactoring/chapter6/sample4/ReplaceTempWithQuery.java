package com.refactoring.chapter6.sample4;

public class ReplaceTempWithQuery {

    private int _quantity;
    private double _itemPrice;

    double calc() {
        return basePrice() * discountFactor();
    }

    double discountFactor() {
        if (basePrice() > 1000) {
            return 0.95;
        } else {
            return 0.98;
        }
    }

    double basePrice() {
        return _quantity * _itemPrice;
    }

}
