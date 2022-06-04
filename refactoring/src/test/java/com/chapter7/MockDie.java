package com.chapter7;

import java.util.ArrayList;
import java.util.List;

public class MockDie implements Rollable{
    private List<Integer> returnValues = new ArrayList<>();
    private int nextReturnedIndex;

    public MockDie() {
    }

    public MockDie(int constantReturnValue) {
        addRoll(constantReturnValue);
    }

    public void addRoll(int returnValue) {
        returnValues.add(returnValue);
    }

    @Override
    public int roll() {
        int val = ((Integer) returnValues.get(nextReturnedIndex++)).intValue();
        if(nextReturnedIndex >= returnValues.size()) {
            nextReturnedIndex = 0;
        }
        return val;
    }
}
