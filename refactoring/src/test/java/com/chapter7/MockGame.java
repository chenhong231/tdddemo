package com.chapter7;

import org.assertj.core.api.Assert;

public class MockGame implements Game {
    private Orc deadOrc = null;
    private Orc orcExpectedToDie = null;

    @Override
    public void hasDie(Orc orc) {
    }

    public void expectHasDied(Orc weakOrc) {

    }
}
