package com.courses.services;

import com.courses.entity.Video;
import com.courses.repository.CourseRepo;
import com.courses.repository.VideoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class AddVideoService {
    @Autowired
    private VideoRepo videoRepo;

    @Autowired
    private CourseRepo courseRepo;
    // Add your methods and logic here for adding videos to courses
    // For example, you might have a method like this:
    public void addVideoToCourse(Video video) {
        log.info("Adding video to course with ID {}", video.getCourseId());
        // Logic to add the video to the course
        // You can use a repository to save the video information in the database
        // Check if the course ID is valid
        courseRepo.findById(video.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + video.getCourseId()));
        video.setCreatedAt(LocalDate.now());
        videoRepo.save(video);
    }
    // Update video
    public void updateVideo(Video video) {
        log.info("Updating video with ID {}", video.getVideoId());
        // Check if the video ID is valid
        Video existingVideo = videoRepo.findById(video.getVideoId())
                .orElseThrow(() -> new IllegalArgumentException("Video not found with ID: " + video.getVideoId()));
        existingVideo.setVideoName(video.getVideoName());
        existingVideo.setDescription(video.getDescription());
        existingVideo.setVideoUrl(video.getVideoUrl());
        existingVideo.setUpdatedAt(LocalDate.now());
        videoRepo.save(existingVideo);
    }

    public List<Video> viewVideos(Long courseId) {
        log.info("Viewing videos for course with ID {}", courseId);
        // Logic to retrieve videos for the specified course
        // You can use a repository to fetch the video information from the database
        return videoRepo.findByCourseId(courseId).orElse(null);
    }
    public Video viewVideo(Long videoId) {
        log.info("Viewing video with ID {}", videoId);
        // Logic to retrieve a specific video by its ID
        // You can use a repository to fetch the video information from the database
        return videoRepo.findById(videoId)
                .orElseThrow(() -> new IllegalArgumentException("Video not found with ID: " + videoId));
    }
}
