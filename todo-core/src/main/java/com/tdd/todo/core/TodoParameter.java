package com.tdd.todo.core;

import com.google.common.base.Strings;
import lombok.Getter;

@Getter
public class TodoParameter {
    private String content;

    private TodoParameter(String content) {
        this.content = content;
    }

    public static TodoParameter of(String content) {
        if(Strings.isNullOrEmpty(content)) {
            throw new IllegalArgumentException("Empty content is not allowed");
        }

        return new TodoParameter(content);
    }
}
