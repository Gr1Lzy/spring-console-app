package com.github.application.service;

import com.github.application.model.Degree;

import java.util.Map;

public interface LectorService {
    Map<Degree, Integer> getDegreeCount(String departmentName);
}
