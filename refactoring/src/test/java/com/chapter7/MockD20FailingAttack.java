package com.chapter7;

public class MockD20FailingAttack implements Rollable{

    @Override
    public int roll() {
        return 10;
    }
}
