package com.refactoring.chapter6.after;

import com.refactoring.chapter6.before.Order;

public class InlineTemp {

    private Order anOrder;

    private boolean method() {
        return anOrder.basePrice() > 1000;
    }
}
