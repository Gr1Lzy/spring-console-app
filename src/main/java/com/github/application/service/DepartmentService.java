package com.github.application.service;

import java.util.List;

public interface DepartmentService {
    String getHeadOfDepartment(String departmentName);
    Double getAverageSalary(String departmentName);
    Integer getCountOfEmployee(String departmentName);
}
