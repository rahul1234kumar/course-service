package com.courses.services;

import com.courses.entity.Teacher;
import com.courses.exception.TeacherNotFoundException;
import com.courses.repository.TeacherRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherService {
    @Autowired
    TeacherRepo teacherRepo;

    public void createTeacher(Teacher teacher) {
        log.info("Creating teacher: {}", teacher);
        // Save the teacher to the database
        teacherRepo.save(teacher);
    }
    public Teacher viewTeacherById(Long teacherId) {
        log.info("Viewing teacher with ID {}", teacherId);
        // Find the teacher by ID
        return teacherRepo.findById(teacherId).orElse(null);
    }
    public void updateTeacher(Teacher teacher,Long teacherId) {
        log.info("Updating teacher with ID {}", teacherId);
        Teacher existingTeacher = teacherRepo.findById(teacherId).orElseThrow(()->new TeacherNotFoundException(String.format("Teacher not found %d",teacherId)));
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setName(teacher.getName());
        existingTeacher.setPassword(teacher.getPassword());

        // Update the teacher in the database
        teacherRepo.save(existingTeacher);
    }
    public void deleteTeacher(Long teacherId) {
        log.info("Deleting teacher with ID {}", teacherId);
        // Delete the teacher from the database
        teacherRepo.deleteById(teacherId);
    }
}
