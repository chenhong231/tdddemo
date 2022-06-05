package com.refactoring.chapter6.after;

public class ExtractMethod {
    private String name;

    void printOwing(double amount) {
        printBanner();
        printDetails(amount);
    }

    private void printDetails(double amount) {
        System.out.println("name:" + name);
        System.out.println("amount" + amount);
    }

    private void printBanner() {

    }
}
