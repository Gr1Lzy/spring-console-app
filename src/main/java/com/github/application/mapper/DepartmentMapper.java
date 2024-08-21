package com.github.application.mapper;

import com.github.application.dto.DepartmentDto;
import com.github.application.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDto toDto(Department department);
    Department toEntity(DepartmentDto departmentDto);
}
