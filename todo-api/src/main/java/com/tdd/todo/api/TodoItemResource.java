package com.tdd.todo.api;

import com.google.common.base.Strings;
import com.tdd.todo.core.TodoIndexParameter;
import com.tdd.todo.core.TodoItem;
import com.tdd.todo.core.TodoItemService;
import com.tdd.todo.core.TodoParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todo-items")
public class TodoItemResource {

    private TodoItemService service;

    @Autowired
    public TodoItemResource(final TodoItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity addTodoItem(@RequestBody final AddTodoItemRequest request) {
        if (Strings.isNullOrEmpty(request.getContent())) {
            return ResponseEntity.badRequest().build();
        }

        final TodoParameter parameter = TodoParameter.of(request.getContent());
        final TodoItem todoItem = this.service.addTodoItem(parameter);

        final URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todoItem.getIndex())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity markAsDone(@PathVariable("id") final int id,
                                     @RequestBody final MarkAsDoneRequest request) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }

        if (!request.isDone()) {
            return ResponseEntity.badRequest().build();
        }

        final Optional<TodoItem> todoItem = this.service.markTodoItemDone(TodoIndexParameter.of(id));

        if (todoItem.isPresent()) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public List<TodoItemResponse> list(@RequestParam(value = "all", defaultValue = "false") final boolean all) {
        final List<TodoItem> items = this.service.list(all);
        return items.stream().map(TodoItemResponse::new).collect(Collectors.toList());
    }
}
