package com.courses.repository;

import com.courses.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> findByTeacherId(Long teacherId);
}
