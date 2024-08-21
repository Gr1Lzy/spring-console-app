package com.github.application;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringConsoleAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringConsoleAppApplication.class, args);
    }
}