package com.tdd.todo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.tdd.todo")
@EnableJpaRepositories({"com.tdd.todo.core"})
@EntityScan({"com.tdd.todo.core"})
public class Bootstrap {

    private static ConfigurableApplicationContext context;

    public static void main(final String[] args) {
        context = SpringApplication.run(Bootstrap.class, args);
    }

    public static void shutdown() {
        context.close();
    }
}
