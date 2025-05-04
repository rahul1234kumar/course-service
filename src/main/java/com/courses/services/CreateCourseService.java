package com.courses.services;

import com.courses.entity.Course;
import com.courses.exception.TeacherNotFoundException;
import com.courses.repository.CourseRepo;
import com.courses.repository.TeacherRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateCourseService {
    @Autowired
    CourseRepo courseRepo;

    @Autowired
    TeacherRepo teacherRepo;

    public void createCourse(Course course,Long teacher_id) {
        log.info("Creating course: {}", course);
        // Check if the teacher exists
        if (teacherRepo.findById(teacher_id).isEmpty()) {
            throw new TeacherNotFoundException(String.format("Teacher not found %d",teacher_id));
        }

        // Set the teacher ID for the course
        course.setTeacherId(teacher_id);

        // Save the course to the database
        courseRepo.save(course);
    }
}
