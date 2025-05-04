package com.courses.repository;

import com.courses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StduentRepo extends JpaRepository<Student, Long> {
    // Custom query methods can be defined here if needed
}
