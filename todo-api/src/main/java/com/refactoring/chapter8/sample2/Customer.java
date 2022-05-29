package com.refactoring.chapter8.sample2;

public class Customer {

    public Customer(String name) {
        this._name = name;
    }

    private final String _name;

    public String getName() {
        return _name;
    }
}
