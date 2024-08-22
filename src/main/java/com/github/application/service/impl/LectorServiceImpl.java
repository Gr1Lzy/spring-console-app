package com.github.application.service.impl;

import com.github.application.model.Degree;
import com.github.application.repository.LectorRepository;
import com.github.application.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    public Map<Degree, Integer> getDegreeCountByDepartment(String departmentName) {
        List<Object[]> results = lectorRepository.countDegreeByDepartment(departmentName);

        Map<Degree, Integer> degreeCount = new EnumMap<>(Degree.class);

        for (Object[] result : results) {
            Degree degree = (Degree) result[0];
            Integer count = ((Number) result[1]).intValue();
            degreeCount.put(degree, count);
        }

        return degreeCount;
    }
}
