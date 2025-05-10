package com.courses.controllers;

import com.courses.entity.Assignment;
import com.courses.entity.Course;
import com.courses.entity.Video;
import com.courses.services.AddAssignmentService;
import com.courses.services.AddVideoService;
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

    @Autowired
    AddAssignmentService addAssignmentService;

    @Autowired
    AddVideoService addVideoService;

    @PostMapping("/create_course/{teacher_id}")
    public String createCourse(@PathVariable Long teacher_id, @RequestBody Course course) {
        log.info("Creating course: {}", course);
        createCourseService.createCourse(course, teacher_id);
        return "Course created successfully!";
    }

    @GetMapping("/view_course/{course_id}")
    public Course viewCourseById(@PathVariable Long course_id) {
        return ResponseEntity.ok(viewCourseService.viewCourseById(course_id)).getBody();
    }

    @PostMapping("/add_assignment")
    public String addAssignment(@RequestBody Assignment assignment) {
        addAssignmentService.addAssignment(assignment);
        return "Assignment added successfully!";
    }

    @PostMapping("/update_assignment")
    public String updateAssignment(@RequestBody Assignment assignment) {
        addAssignmentService.updateAssignment(assignment);
        return "Assignment updated successfully!";
    }

    @PostMapping("/add_video")
    public String addVideo(@RequestBody Video video) {
        addVideoService.addVideoToCourse(video);
        return "Video added successfully!";
    }

    @PostMapping("/update_video")
    public String updateVideo(@RequestBody Video video) {
        addVideoService.updateVideo(video);
        return "Video updated successfully!";
    }

    @GetMapping("view_teachers_courses/{teacher_id}")
    public List<Course> viewAllCourses(@PathVariable Long teacher_id) {
        return ResponseEntity.ok(viewCourseService.viewAllCourses(teacher_id)).getBody();
    }

    @GetMapping("/view_videos/{course_id}")
    public List<Video> viewVideos(@PathVariable Long course_id) {
        return ResponseEntity.ok(addVideoService.viewVideos(course_id)).getBody();
    }

    @GetMapping("/view_assignments/{course_id}")
    public List<Assignment> viewAssignments(@PathVariable Long course_id) {
        return ResponseEntity.ok(addAssignmentService.viewAssignments(course_id)).getBody();
    }

    @GetMapping("/view_video/{video_id}")
    public Video viewVideoById(@PathVariable Long video_id) {
        return ResponseEntity.ok(addVideoService.viewVideo(video_id)).getBody();
    }

    @GetMapping("/view_assignment/{assignment_id}")
    public Assignment viewAssignmentById(@PathVariable Long assignment_id) {
        return ResponseEntity.ok(addAssignmentService.viewAssignment(assignment_id)).getBody();
    }
}