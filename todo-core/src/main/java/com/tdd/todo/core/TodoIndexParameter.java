package com.tdd.todo.core;

import lombok.Getter;

public class TodoIndexParameter {

    @Getter
    private int index;

    private TodoIndexParameter(int index) {
        this.index = index;
    }

    public static TodoIndexParameter of(int index) {
        return new TodoIndexParameter(index);
    }
}
