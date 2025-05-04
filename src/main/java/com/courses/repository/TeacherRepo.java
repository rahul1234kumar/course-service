package com.courses.repository;

import com.courses.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    // Custom query methods can be defined here if needed
}
