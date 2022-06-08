package com.refactoring.chapter7.after;

public class AccountType {

    private double interestRate;

    public boolean isPremium() {
        return false;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    double overdraftCharge(int daysOverdrawn) {
        if(isPremium()) {
            double result = 10;
            if(daysOverdrawn > 7) {
                result += (daysOverdrawn - 7) * 0.85;
            }
            return result;
        } else {
            return daysOverdrawn * 1.75;
        }
    }
}
