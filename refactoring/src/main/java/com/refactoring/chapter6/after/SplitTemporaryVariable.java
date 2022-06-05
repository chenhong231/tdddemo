package com.refactoring.chapter6.after;

public class SplitTemporaryVariable {
    private int height;
    private int width;
    private double primaryForce;
    private double mass;
    private int delay;
    private double secondaryForce;

    private void method() {
        double perimeter = 2 * (height + width);
        System.out.println(perimeter);

        double area = height * width;
        System.out.println(area);
    }

    private double getDistanceTravelled(int time) {
        double result;
        final double primaryAcc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if(secondaryTime > 0) {
            double primaryVel = primaryAcc * delay;
            final double secondaryAcc = (primaryForce + secondaryForce) / mass;
            result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
        }

        return result;
    }
}
