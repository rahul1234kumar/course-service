package com.courses.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "video_info")
public class Video {
    private Long courseId;
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long videoId; // Unique identifier for the video
    private String videoUrl;
    private String videoName;
    private String description;
    private Double duration; // Duration of the video
    private LocalDate createdAt; // Timestamp for when the video was added
    private LocalDate updatedAt; // Timestamp for when the video was last updated
}
