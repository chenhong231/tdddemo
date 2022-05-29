package com.tdd.todo.core;

import com.google.common.collect.Streams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoItemService {

    private TodoItemRepository repository;
    public TodoItemService(TodoItemRepository repository) {
        this.repository = repository;
    }

    public TodoItem addTodoItem(TodoParameter parameter) {
        if(parameter == null) {
            throw new IllegalArgumentException("Null or empty content is not allowed");
        }
        final TodoItem item = new TodoItem(parameter.getContent());
        return repository.save(item);
    }

    public Optional<TodoItem> markTodoItemDone(TodoIndexParameter index) {
        final Iterable<TodoItem> all = this.repository.findAll();

        final Optional<TodoItem> optionalItem = StreamSupport.stream(all.spliterator(), false)
                .filter(element -> element.getIndex() == index.getIndex())
                .findFirst();

        return optionalItem.flatMap(this::doMarkAsDone);
    }

    private Optional<TodoItem> doMarkAsDone(TodoItem item) {
        item.markDone();
        return Optional.of(this.repository.save(item));
    }

    public List<TodoItem> list(boolean all) {
        return Streams.stream(this.repository.findAll())
                .filter(item -> all || !item.isDone())
                .collect(Collectors.toList());
    }
}
