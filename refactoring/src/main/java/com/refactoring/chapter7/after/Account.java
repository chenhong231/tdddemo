package com.refactoring.chapter7.after;

public class Account {

    private AccountType type;
    private int daysOverdrawn;

    double interestForAmountDays(double amount, int days) {
        return type.getInterestRate() * amount * days / 365;
    }

    double bankCharge() {
        double result = 4.5;
        if(daysOverdrawn > 0) {
            result += type.overdraftCharge(daysOverdrawn);
        }
        return result;
    }
}
