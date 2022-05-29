package com.tdd.todo.cli;

import com.tdd.todo.cli.file.FileTodoItemRepository;
import com.tdd.todo.core.TodoItemRepository;
import com.tdd.todo.core.TodoItemService;
import picocli.CommandLine;

import java.io.File;

public class ObjectFactory {
    public TodoItemService createService(File repositoryFile) {
        final TodoItemRepository repository = new FileTodoItemRepository(repositoryFile);
        return new TodoItemService(repository);
    }

    public CommandLine createCommandLine(File repositoryFile) {
        return new CommandLine(createTodoCommand(repositoryFile));
    }

    private TodoCommand createTodoCommand(File repositoryFile) {
        final TodoItemService service = createService(repositoryFile);
        return new TodoCommand(service);
    }


}
