package com.tdd.todo.cli;

import com.tdd.todo.core.TodoItem;
import com.tdd.todo.core.TodoItemService;
import com.tdd.todo.core.TodoParameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoCommandTest {

    @TempDir
    File tempDir;
    private TodoItemService service;
    private CommandLine cli;

    @BeforeEach
    public void setUp() {
        final ObjectFactory factory = new ObjectFactory();
        final File repositoryFile = new File(tempDir, "repository.json");
        this.service = factory.createService(repositoryFile);
        this.cli = factory.createCommandLine(repositoryFile);
    }

    @Test
    public void should_mark_as_done() {
        service.addTodoItem(TodoParameter.of("foo"));

        cli.execute("done", "1");

        final List<TodoItem> items = service.list(true);
        assertThat(items.get(0).isDone()).isTrue();
    }
}
