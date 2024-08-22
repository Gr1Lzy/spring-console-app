package com.github.application.service.impl;

import com.github.application.dto.DepartmentDto;
import com.github.application.mapper.DepartmentMapper;
import com.github.application.model.Department;
import com.github.application.repository.DepartmentRepository;
import com.github.application.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public String getHeadOfDepartment(String departmentName) {
        Optional<Department> departmentOpt = departmentRepository.findByName(departmentName);

        if (departmentOpt.isEmpty()) {
            return "";
        }

        Department department = departmentOpt.get();
        DepartmentDto departmentDto = DepartmentMapper.INSTANCE.toDto(department);

        return departmentDto.getHeadOfDepartment().getName();
    }

    @Override
    public Double getAverageSalary(String departmentName) {
        Optional<Double> averageSalary = departmentRepository.calculateAverageByDepartment(departmentName);

        return averageSalary.orElse(0.0);
    }

    @Override
    public Integer getCountOfEmployee(String departmentName) {
        Optional<Integer> countedEmployees = departmentRepository.countEmployeesByDepartment(departmentName);

        return countedEmployees.orElse(0);
    }
}
