package com.github.application.repository;

import com.github.application.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("SELECT l.degree, COUNT(l) FROM Lector l JOIN l.departments d WHERE d.name = :departmentName GROUP BY l.degree")
    List<Object[]> countDegreeByDepartment(@Param("departmentName") String departmentName);

    @Query("SELECT l FROM Lector l WHERE LOWER(l.name) LIKE LOWER(:searchTerm)")
    List<Lector> findByNameContainingIgnoreCase(@Param("searchTerm") String searchTerm);
}
