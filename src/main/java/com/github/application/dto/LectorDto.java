package com.github.application.dto;

import com.github.application.model.Degree;
import com.github.application.model.Department;
import lombok.Data;

import java.util.Set;

@Data
public class LectorDto {
    private Long id;
    private String name;
    private Degree degree;
    private Double salary;
    private Set<Department> departments;
}
