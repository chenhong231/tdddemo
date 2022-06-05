package com.refactoring.chapter6.after;

import java.util.List;

public class ExtractMethodWithLocalVariable {

    private List<Order> orders;
    private String name;

    void printOwing() {
        printBanner();

        double outstanding = getOutstanding();
        printDetails(outstanding);
    }

    void printOwing1(double previousAmount) {
        printBanner();

        double outstanding = getOutstanding(previousAmount);
        printDetails(outstanding);
    }

    private double getOutstanding(double previousAmount) {
        double result = previousAmount * 1.2;
        for(Order order : orders) {
            result += order.getAmount();
        }
        return result;
    }

    private double getOutstanding() {
        double result = 0.0;
        for(Order order : orders) {
            result += order.getAmount();
        }
        return result;
    }

    private void printDetails(double outstanding) {
        System.out.println("name:" + name);
        System.out.println("amount" +outstanding);
    }

    private void printBanner() {
        System.out.println("************************************************");
        System.out.println("****************Customer Owes*******************");
        System.out.println("************************************************");
    }
}
