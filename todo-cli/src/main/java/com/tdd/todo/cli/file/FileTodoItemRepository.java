package com.tdd.todo.cli.file;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.tdd.todo.core.TodoItem;
import com.tdd.todo.core.TodoItemRepository;
import com.tdd.todo.util.Jsons;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class FileTodoItemRepository implements TodoItemRepository {
    private final File file;

    public FileTodoItemRepository(File file) {
        this.file = file;
    }

    @Override
    public TodoItem save(TodoItem todoItem) {
        if(todoItem == null) {
            throw new IllegalArgumentException("Todo item should not be null");
        }

        final Iterable<TodoItem> items = findAll();
        final Iterable<TodoItem> newContent = toSaveContent(todoItem, items);
        Jsons.writeObjects(this.file, newContent);
        return todoItem;
    }


    @Override
    public Iterable<TodoItem> findAll() {

        if(this.file.length() == 0) {
            return ImmutableList.of();
        }
        return Jsons.toObjects(this.file);
    }

    private Iterable<TodoItem> toSaveContent(TodoItem newItem, Iterable<TodoItem> items) {
        if (newItem.getIndex() == 0) {
            long newIndex = Iterables.size(items) + 1;
            newItem.assignIndex(newIndex);

            return ImmutableList.<TodoItem>builder()
                    .addAll(items)
                    .add(newItem)
                    .build();
        }

        final List newItems = StreamSupport.stream(items.spliterator(), false)
                .map(item -> updateItem(newItem, item))
                .collect(Collectors.toList());

        return ImmutableList.<TodoItem>builder()
                .addAll(newItems)
                .build();
    }

    private Object updateItem(TodoItem newItem, TodoItem item) {
        if(newItem.getIndex() == item.getIndex()) {
            return newItem;
        }
        return item;
    }
}
