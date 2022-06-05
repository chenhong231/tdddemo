package com.refactoring.chapter6.before;

public class ExtractMethod {
    private String name;

    void printOwing(double amount) {
        printBanner();

        System.out.println("name:" + name);
        System.out.println("amount" + amount);
    }

    private void printBanner() {
    }
}
