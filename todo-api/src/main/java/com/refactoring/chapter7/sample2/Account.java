package com.refactoring.chapter7.sample2;

public class Account {

    private AccountType _type;
    double interestForAmount_days (double amount, int days) {
        return _type.get_interestRate() * amount * days / 365;
    }
}
