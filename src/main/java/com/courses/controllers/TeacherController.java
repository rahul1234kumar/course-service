package com.courses.controllers;

import com.courses.entity.Teacher;
import com.courses.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    // Add your endpoints and methods here
    // For example, you can create methods for creating, viewing, updating, and deleting teachers

    // Example endpoint
    @Autowired
    private TeacherService teacherService;
     @GetMapping("/find/{teacherId}")
     public Teacher getTeacherById(@PathVariable Long teacherId) {
         return teacherService.viewTeacherById(teacherId);
     }
     @PostMapping("/create")
     public String createTeacher(@RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
        return "Teacher created successfully!";
     }

    @PostMapping("/update/{teacherId}")
    public String createTeacher(@RequestBody Teacher teacher, @PathVariable Long teacherId) {
        teacherService.updateTeacher(teacher, teacherId);
        return "Teacher created successfully!";
    }
    @DeleteMapping("/delete/{teacherId}")
    public String deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
        return "Teacher deleted successfully!";
    }



}
