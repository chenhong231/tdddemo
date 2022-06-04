package com.chapter7;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void should_miss_attack() {

        Rollable d20 = new MockDie(10);
        Player badFighter = new Player(d20);
        MockGame mockGame = new MockGame();
        Orc anOrc = new Orc(mockGame, 30);
        assertThat(badFighter.attack(anOrc)).isFalse();
    }

    @Test
    public void should_hit() {
        Rollable d20 = new MockDie(18);
        Player goodFighter = new Player(d20);
        MockGame mockGame = new MockGame();
        Orc anOrc = new Orc(mockGame, 30);
        assertThat(goodFighter.attack(anOrc)).isTrue();
    }

    @Test
    public void should_not_kill() {
        MockGame mockGame = new MockGame();
        Orc strongOrc = new Orc(mockGame, 30);

        MockDie d20 = new MockDie();
        d20.addRoll(18);
        d20.addRoll(10);

        Player fighter = new Player(d20);
        fighter.attack(strongOrc);
        assertThat(strongOrc.isDead()).isFalse();
    }

    @Test
    public void should_kill() {
        MockGame mockGame = new MockGame();
        Orc weakOrc = new Orc(mockGame, 10);
        mockGame.expectHasDied(weakOrc);

        MockDie d20 = new MockDie();
        d20.addRoll(18);
        d20.addRoll(15);

        Player fighter = new Player(d20);
        fighter.attack(weakOrc);
        assertThat(weakOrc.isDead()).isTrue();
    }
}
