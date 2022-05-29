package com.tdd.todo.cli;

import com.google.common.base.Strings;
import com.tdd.todo.core.TodoIndexParameter;
import com.tdd.todo.core.TodoItem;
import com.tdd.todo.core.TodoItemService;
import picocli.CommandLine;

import java.util.List;
import java.util.Optional;

@CommandLine.Command(name = "todo")
public class TodoCommand {

    private final TodoItemService service;

    @CommandLine.Spec
    private CommandLine.Model.CommandSpec spec;

    public TodoCommand(TodoItemService service) {
        this.service = service;
    }

    @CommandLine.Command(name="done")
    public int markAsDone(@CommandLine.Parameters(index = "0") final int index) {
        if(index <= 0) {
            throw new CommandLine.ParameterException(spec.commandLine(), "index should be greater than 0");
        }

        final Optional<TodoItem> todoItem = this.service.markTodoItemDone(TodoIndexParameter.of(index));
        if(!todoItem.isPresent()) {
            throw new CommandLine.ParameterException(spec.commandLine(), "unknown todo item index");
        }

        final TodoItem actual = todoItem.get();
        System.out.printf("Item <%d> done%n", actual.getIndex());
        return 0;
    }
}
