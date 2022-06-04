package com.chapter7;

public class Player {

    Rollable myD20 = null;

    public Player(Rollable d20) {
        myD20 = d20;
    }

    public boolean attack(Orc anOrc) {
        if(myD20.roll() >= 13) {
            return hit(anOrc);
        } else {
            return miss();
        }
    }

    private boolean hit(Orc anOrc) {
        anOrc.injure(myD20.roll());
        return true;
    }

    private boolean miss() {
        return false;
    }
}
