package com.chapter7;

public class Orc {
    private Game game = null;
    private int health = 0;

    public Orc(Game theGame, int hitPoints) {
        this.game = theGame;
        health = hitPoints;
    }

    public void injure(int damage) {
        health -= damage;
        if(health <= 0) {
            die();
        }
    }

    private void die() {
        game.hasDie(this);
    }

    public boolean isDead() {
        return health <= 0;
    }
}
