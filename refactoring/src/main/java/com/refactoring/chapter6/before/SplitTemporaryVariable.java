package com.refactoring.chapter6.before;

public class SplitTemporaryVariable {
    private int height;
    private int width;
    private double primaryForce;
    private double mass;
    private int delay;
    private double secondaryForce;

    private void method() {
        double temp = 2 * (height + width);
        System.out.println(temp);

        temp = height * width;
        System.out.println(temp);
    }

    private double getDistanceTravelled(int time) {
        double result;
        double acc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if(secondaryTime > 0) {
            double primaryVel = acc * delay;
            acc = (primaryForce + secondaryForce) / mass;
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }

        return result;
    }
}
