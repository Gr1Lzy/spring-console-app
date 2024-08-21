package com.github.application;

import com.github.application.service.DepartmentService;
import com.github.application.service.GlobalSearchService;
import com.github.application.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringConsoleAppApplication implements CommandLineRunner {
    private final LectorService lectorService;
    private final DepartmentService departmentService;
    private final GlobalSearchService globalSearchService;

    public static void main(String[] args) {
        SpringApplication.run(SpringConsoleAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}