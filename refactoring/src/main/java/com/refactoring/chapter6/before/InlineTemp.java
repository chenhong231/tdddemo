package com.refactoring.chapter6.before;

public class InlineTemp {

    private Order anOrder;

    private boolean method() {
        double basePrice = anOrder.basePrice();
        return basePrice > 1000;
    }
}
