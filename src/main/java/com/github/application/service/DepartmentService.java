package com.github.application.service;

public interface DepartmentService {
    String getHeadOfDepartment(String departmentName);
    Double getAverageSalary(String departmentName);
    Integer getCountOfEmployee(String departmentName);
}
