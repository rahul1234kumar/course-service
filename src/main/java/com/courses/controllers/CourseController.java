package com.courses.controllers;

import com.courses.entity.Course;
import com.courses.services.CreateCourseService;
import com.courses.services.ViewCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {

    @Autowired
    CreateCourseService createCourseService;

    @Autowired
    ViewCourseService viewCourseService;

    @PostMapping("/create_course/{teacher_id}")
    public String createCourse(@PathVariable Long teacher_id, @RequestBody Course course) {
        log.info("Creating course: {}", course);
        createCourseService.createCourse(course, teacher_id);
        return "Course created successfully!";
    }

    @GetMapping("/view_course/{course_id}")
    public Course viewCourseById(@PathVariable Long course_id) {
        log.info("Viewing course with ID {}", course_id);
        return ResponseEntity.ok(viewCourseService.viewCourseById(course_id)).getBody();
    }

    @GetMapping("view_teachers_courses/{teacher_id}")
    public List<Course> viewAllCourses(@PathVariable Long teacher_id) {
        log.info("Viewing all courses for teacher with ID {}", teacher_id);
        return ResponseEntity.ok(viewCourseService.viewAllCourses(teacher_id)).getBody();
    }



}
