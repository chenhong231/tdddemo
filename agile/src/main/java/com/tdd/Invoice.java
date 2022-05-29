package com.tdd;

import java.util.List;

public class Invoice {

    public String customer;
    public List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    double getTotalAmount() {
        return performances.stream().mapToDouble(Performance::getThisAmount).sum();
    }

    double getVolumeCredits() {
        return performances.stream().mapToDouble(Performance::getThisCredits).sum();
    }

}
