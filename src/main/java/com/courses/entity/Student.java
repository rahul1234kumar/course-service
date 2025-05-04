package com.courses.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "student_info")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment for MySQL
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

}