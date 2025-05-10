package com.courses.repository;

import com.courses.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VideoRepo extends JpaRepository<Video, Long> {
     Optional<List<Video>> findByCourseId(Long courseId);
    // Custom query methods can be defined here if needed
}
