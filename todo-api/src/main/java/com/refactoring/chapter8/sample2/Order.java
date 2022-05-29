package com.refactoring.chapter8.sample2;

import java.util.Collection;
import java.util.Iterator;

public class Order {

    public Order (String customerName) {
        _customer = new Customer(customerName);
    }

    public String getCustomerName() {
        return _customer.getName();
    }

    public void setCustomer(String customerName) {
        _customer = new Customer(customerName);
    }

    private Customer _customer;


    private static int numberOfOrdersFor(Collection orders, String
            customer) {
        int result = 0;
        Iterator iter = orders.iterator();
        while (iter.hasNext()) {
            Order each = (Order) iter.next();
            if (each.getCustomerName().equals(customer)) result++;
        }
        return result;
    }
}
