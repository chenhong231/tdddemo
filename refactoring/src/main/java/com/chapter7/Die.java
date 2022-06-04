package com.chapter7;

import java.util.Random;

public class Die implements Rollable {

    private int sides = 0;
    private Random generator = null;

    public Die(int numberOfSide) {
        sides = numberOfSide;
        generator = new Random();
    }

    @Override
    public int roll() {
        return generator.nextInt(sides) + 1;
    }
}
