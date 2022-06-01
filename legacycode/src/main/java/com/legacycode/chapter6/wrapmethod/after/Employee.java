package com.legacycode.chapter6.wrapmethod.after;

import com.legacycode.chapter6.wrapmethod.model.Money;
import com.legacycode.chapter6.wrapmethod.model.Timecard;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Employee {

    private List<Timecard> timecards = new ArrayList<>();
    private List<Date> payPeriod = new ArrayList<>();
    private int payRate = 1;

    private Date date = new Date();

    public void pay() {
        Money amount = new Money();
        for(Iterator it = timecards.iterator(); it.hasNext(); ) {
            Timecard card = (Timecard) it.next();
            if(payPeriod.contains(date)) {
                amount.add(card.getHours() * payRate);
            }
        }
        pay(date, amount);
    }

    private void pay(Date date, Money amount) {
    }
}
