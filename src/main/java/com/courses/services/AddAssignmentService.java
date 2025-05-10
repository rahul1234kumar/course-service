package com.courses.services;

import com.courses.entity.Assignment;
import com.courses.entity.Course;
import com.courses.repository.AssignmentRepo;
import com.courses.repository.CourseRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class AddAssignmentService {
    @Autowired
    private AssignmentRepo assignmentRepo;

    @Autowired
    private CourseRepo courseRepo;

    public void addAssignment(Assignment assignment) {

        log.info("Adding assignment to course with ID {}", assignment.getCourseId());
        Long courseId = assignment.getCourseId();
        // Check if the course ID is valid
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));
        assignment.setCreatedAt(LocalDate.now());
        assignmentRepo.save(assignment);
    }
    //update assignment
    public void updateAssignment(Assignment assignment) {
        log.info("Updating assignment with ID {}", assignment.getAssignmentId());
        // Check if the assignment ID is valid
        Assignment existingAssignment = assignmentRepo.findById(assignment.getAssignmentId())
                .orElseThrow(() -> new IllegalArgumentException("Assignment not found with ID: " + assignment.getAssignmentId()));
        existingAssignment.setDescription(assignment.getDescription());
        existingAssignment.setDueDate(assignment.getDueDate());
        existingAssignment.setUpdatedAt(LocalDate.now());
        assignmentRepo.save(existingAssignment);
    }

    public List<Assignment> viewAssignments(Long courseId) {
        log.info("Viewing assignments for course with ID {}", courseId);
        // Logic to retrieve assignments for the specified course
        // You can use a repository to fetch the assignment information from the database
        return assignmentRepo.findByCourseId(courseId).orElse(null);
    }

    public Assignment viewAssignment(Long assignmentId) {
        log.info("Viewing assignment with ID {}", assignmentId);
        // Logic to retrieve a specific assignment by its ID
        // You can use a repository to fetch the assignment information from the database
        return assignmentRepo.findById(assignmentId)
                .orElseThrow(() -> new IllegalArgumentException("Assignment not found with ID: " + assignmentId));
    }
}
