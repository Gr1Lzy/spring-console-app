package com.github.application.repository;

import com.github.application.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT d FROM Department d WHERE d.name = :name")
    Optional<Department> findByName(String name);

    @Query("SELECT AVG(l.salary) FROM Lector l JOIN l.departments d WHERE d.name = :departmentName")
    Optional<Double> calculateAverageByDepartment(String departmentName);

    @Query("SELECT COUNT(l) FROM Lector l JOIN l.departments d WHERE d.name = :departmentName")
    Optional<Integer> countEmployeesByDepartment(String departmentName);

    @Query("SELECT d FROM Department d WHERE LOWER(d.name) LIKE LOWER(:searchTerm)")
    List<Department> findByNameContainingIgnoreCase(@Param("searchTerm") String searchTerm);
}
