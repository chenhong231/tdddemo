package com.refactoring.chapter8.sample3;

public class Customer {

    private Customer(String name) {
        this._name = name;
    }

    private final String _name;

    public String getName() {
        return _name;
    }

    public static Customer create(String name) {
        return new Customer(name);
    }
}
