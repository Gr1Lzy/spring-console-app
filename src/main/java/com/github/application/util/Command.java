package com.github.application.util;

import lombok.Getter;

@Getter
public enum Command {
    GET_HEAD_OF_DEPARTMENT("Who is head of department {department_name}"),
    GET_STATISTICS("Show {department_name} statistics"),
    GET_AVERAGE_SALARY("Show the average salary for the department {department_name}"),
    GET_COUNT_OF_EMPLOYEE("Show count of employee for {department_name}"),
    GET_GLOBAL_SEARCH("Global search by {template}"),
    HELP("help");

    private final String commandLine;

    Command(String commandLine) {
        this.commandLine = commandLine;
    }

    public static Command fromString(String command) {
        String normalizedCommand = command.toLowerCase().trim();

        if (normalizedCommand.startsWith("who is head of department")) {
            return GET_HEAD_OF_DEPARTMENT;
        } else if (normalizedCommand.startsWith("show the average salary for the department")) {
            return GET_AVERAGE_SALARY;
        } else if (normalizedCommand.startsWith("show") && normalizedCommand.contains("statistics")) {
            return GET_STATISTICS;
        } else if (normalizedCommand.startsWith("show count of employee for")) {
            return GET_COUNT_OF_EMPLOYEE;
        } else if (normalizedCommand.startsWith("global search by")) {
            return GET_GLOBAL_SEARCH;
        } else if (normalizedCommand.equals("help")) {
            return HELP;
        }

        throw new IllegalArgumentException("No such command: " + command);
    }
}
