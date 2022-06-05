package com.refactoring.chapter6.before;

import java.util.List;

public class ExtractMethodWithLocalVariable {

    private List<Order> orders;
    private String name;

    void printOwing() {
        double outstanding = 0.0;

        System.out.println("************************************************");
        System.out.println("****************Customer Owes*******************");
        System.out.println("************************************************");

        for(Order order : orders) {
            outstanding += order.getAmount();
        }

        System.out.println("name:" + name);
        System.out.println("amount" +outstanding);
    }
}
