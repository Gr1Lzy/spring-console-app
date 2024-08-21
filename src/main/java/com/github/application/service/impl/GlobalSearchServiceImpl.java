package com.github.application.service.impl;

import com.github.application.model.Department;
import com.github.application.model.Lector;
import com.github.application.repository.DepartmentRepository;
import com.github.application.repository.LectorRepository;
import com.github.application.service.GlobalSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class GlobalSearchServiceImpl implements GlobalSearchService {
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Override
    public List<String> searchByTemplate(String template) {
        String searchTerm = "%" + template.trim().toLowerCase() + "%";

        List<String> departmentResults = departmentRepository.findByNameContainingIgnoreCase(searchTerm)
                .stream()
                .map(Department::getName)
                .toList();

        List<String> lectorResults = lectorRepository.findByNameContainingIgnoreCase(searchTerm)
                .stream()
                .map(Lector::getName)
                .toList();

        return Stream.of(departmentResults, lectorResults)
                .flatMap(Collection::stream)
                .toList();
    }
}
