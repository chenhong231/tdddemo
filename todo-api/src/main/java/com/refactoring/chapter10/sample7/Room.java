package com.refactoring.chapter10.sample7;

public class Room {

    private TempRange tempRange;

    boolean withinPlan(HeatingPlan plan) {
        int low = daysTempRange().getLow();
        int high = daysTempRange().getHigh();
        return plan.withinRange(daysTempRange(), low, high);
    }

    private TempRange daysTempRange() {
        return tempRange;
    }
}
