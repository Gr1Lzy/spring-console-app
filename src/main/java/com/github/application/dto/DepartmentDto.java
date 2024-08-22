package com.github.application.dto;

import com.github.application.model.Lector;
import lombok.Data;

import java.util.Set;

@Data
public class DepartmentDto {
    private Long id;
    private String name;
    private Lector headOfDepartment;
    private Set<Lector> lectors;
}
