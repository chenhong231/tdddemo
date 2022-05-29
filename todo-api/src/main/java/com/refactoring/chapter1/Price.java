package com.refactoring.chapter1;

abstract class Price {
    abstract int getPriceCode();

    abstract public double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
