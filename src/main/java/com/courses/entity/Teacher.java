package com.courses.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teacher_info")
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String location; // optional field like country or city
}
