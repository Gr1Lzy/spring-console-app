package com.github.application;

import com.github.application.model.Degree;
import com.github.application.service.DepartmentService;
import com.github.application.service.GlobalSearchService;
import com.github.application.service.LectorService;
import com.github.application.util.Command;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringConsoleAppApplication implements CommandLineRunner {
    private final LectorService lectorService;
    private final DepartmentService departmentService;
    private final GlobalSearchService globalSearchService;

    private static final Logger logger = LoggerFactory.getLogger(SpringConsoleAppApplication.class);
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(SpringConsoleAppApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("Enter your command: ");
        logger.info("Type `help` for command menu");

        while (true) {
            String input = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(input)) {
                logger.info("Exiting the application.");
                break;
            }

            try {
                Command command = Command.fromString(input);
                handleCommand(command, input);
            } catch (IllegalArgumentException e) {
                logger.warn(e.getMessage());
            }
        }
    }

    private void handleCommand(Command command, String input) {
        String departmentName;
        switch (command) {
            case GET_HEAD_OF_DEPARTMENT:
                departmentName = extractParameter(input, "Who is head of department", "");
                logResult(departmentName, "Head of {} department is {}",
                        () -> departmentService.getHeadOfDepartment(departmentName));
                break;
            case GET_AVERAGE_SALARY:
                departmentName = extractParameter(input, "Show the average salary for the department", "");
                logResult(departmentName, "The average salary of {} is {}",
                        () -> String.valueOf(departmentService.getAverageSalary(departmentName)));
                break;
            case GET_STATISTICS:
                departmentName = extractParameter(input, "Show", "statistics");
                if (departmentName != null) {
                    Map<Degree, Integer> degreeCount = lectorService.getDegreeCountByDepartment(departmentName);
                    logger.info("assistants - {}", degreeCount.getOrDefault(Degree.ASSISTANT, 0));
                    logger.info("associate professors - {}", degreeCount.getOrDefault(Degree.ASSOCIATE_PROFESSOR, 0));
                    logger.info("professors - {}", degreeCount.getOrDefault(Degree.PROFESSOR, 0));
                } else {
                    logger.warn("Department name not found in the command.");
                }
                break;
            case GET_COUNT_OF_EMPLOYEE:
                departmentName = extractParameter(input, "Show count of employee for", "");
                logResult(departmentName, "The count of employees in the department {} is {}",
                        () -> String.valueOf(departmentService.getCountOfEmployee(departmentName)));
                break;
            case GET_GLOBAL_SEARCH:
                String template = extractParameter(input, "Global search by", "");
                logGlobalSearchResults(template);
                break;
            case HELP:
                printHelpMenu();
                break;
            default:
                logger.warn("Unknown command");
        }
    }

    private void logResult(String parameter, String message, ResultSupplier supplier) {
        if (parameter != null) {
            String result = supplier.get();
            logger.info(message, parameter, result);
        } else {
            logger.warn("Parameter not found in the command.");
        }
    }

    private void logGlobalSearchResults(String template) {
        if (template != null) {
            List<String> results = globalSearchService.searchByTemplate(template);
            if (results.isEmpty()) {
                logger.warn("No results found for the given template.");
            } else {
                String resultString = String.join(", ", results);
                logger.info(resultString);
            }
        } else {
            logger.warn("Template not found in the command.");
        }
    }

    private void printHelpMenu() {
        logger.info("Available commands:");
        for (Command command : Command.values()) {
            logger.info(command.getCommandLine());
        }
    }

    private String extractParameter(String input, String prefix, String suffix) {
        int startIndex = input.indexOf(prefix) + prefix.length();
        int endIndex = suffix.isEmpty() ? input.length() : input.indexOf(suffix, startIndex);
        if (startIndex >= prefix.length() && endIndex >= 0) {
            return input.substring(startIndex, endIndex).trim();
        }
        return null;
    }

    @FunctionalInterface
    private interface ResultSupplier {
        String get();
    }
}
