package org.example;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class app {

    @Getter
    private static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(app.class, args);
    }

    public static void start() {
        context = SpringApplication.run(app.class);
    }
}
