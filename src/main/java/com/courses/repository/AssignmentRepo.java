package com.courses.repository;

import com.courses.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepo extends JpaRepository<Assignment, Long> {
    Optional<List<Assignment>> findByCourseId(Long courseId);
    // Custom query methods can be defined here if needed
}
