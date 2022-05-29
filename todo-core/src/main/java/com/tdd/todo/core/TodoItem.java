package com.tdd.todo.core;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "todo_items")
public class TodoItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long index;

    @Column
    private String content;

    @Column
    private boolean done;

    public TodoItem() {
    }

    public TodoItem(String content) {
        this.content = content;
        this.done = false;
    }

    public void assignIndex(final long index) {
        this.index = index;
    }


    public void markDone() {
        this.done = true;
    }
}
