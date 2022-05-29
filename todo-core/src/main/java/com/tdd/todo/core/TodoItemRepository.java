package com.tdd.todo.core;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface TodoItemRepository extends Repository<TodoItem, Long> {
    TodoItem save(TodoItem todoItem);

    Iterable<TodoItem> findAll();
}
