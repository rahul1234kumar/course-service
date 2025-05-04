package com.courses.services;

import com.courses.entity.Course;
import com.courses.entity.Teacher;
import com.courses.exception.CourseNotFoundException;
import com.courses.exception.TeacherNotFoundException;
import com.courses.repository.CourseRepo;
import com.courses.repository.TeacherRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class ViewCourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    TeacherRepo teacherRepo;
    @Cacheable(value = "courseCache", key = "#courseId")
    public Course viewCourseById(Long courseId) {

        Course course = courseRepo.findById(courseId).orElseThrow(() -> new CourseNotFoundException(String.format("Course not found %d",courseId)));
        log.info("Viewing course with ID {}", courseId);
        return course;

    }
    @Cacheable(value = "teacherCache", key = "#teacherId")

    public List<Course> viewAllCourses(Long teacherId) {
       Teacher teacher = teacherRepo.findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException(String.format("Teacher not found %d",teacherId)));
       log.info("Viewing all courses for teacher with ID {}", teacherId);
       return courseRepo.findByTeacherId(teacher.getId());
    }
}
