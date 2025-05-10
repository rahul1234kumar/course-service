package com.courses.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "assignment_info")
public class Assignment {
    private Long courseId;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long assignmentId;
    private LocalDate dueDate;
    private String description;
    private String file;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
