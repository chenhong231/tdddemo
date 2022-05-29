package com.refactoring.chapter6.sample1;

import java.util.Enumeration;
import java.util.Vector;

public class ExtractMethod {

    private String _name;
    private Vector _orders = new Vector();

    void printOwing(double amount) {
        printBanner();
        printDetails(amount);
    }

    private void printDetails(double amount) {
        //print details
        System.out.println ("name:" + _name);
        System.out.println ("amount" + amount);
    }

    private void printBanner() {

    }

    // 无局部变量
    void printOwing() {
        printOwingBanner();
        double outstanding = getOutstanding();
        printOwingDetails(outstanding);
    }

    private double getOutstanding() {
        double result = 0;
        Enumeration e = _orders.elements();
        // calculate outstanding
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }

    private void printOwingDetails(double outstanding) {
        //print details
        System.out.println ("name:" + _name);
        System.out.println ("amount" + outstanding);
    }

    private void printOwingBanner() {
        // print banner
        System.out.println ("**************************");
        System.out.println ("***** Customer Owes ******");
        System.out.println ("**************************");
    }

    //=====================================================

    void printOwing1(double previousAmount) {
        printBanner();
        double outstanding = getOutstanding1(previousAmount * 1.2);
        printDetails(outstanding);
    }

    double getOutstanding1(double initialValue) {
        double result = initialValue;
        Enumeration e = _orders.elements();
        // calculate outstanding
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }

        return result;
    }
}
