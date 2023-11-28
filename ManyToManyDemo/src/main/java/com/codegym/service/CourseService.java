package com.codegym.service;

import com.codegym.model.Course;
import com.codegym.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourse() {
        return this.courseRepository.findAll();
    }


    public void add(Course course) {
        this.courseRepository.save(course);
    }
}
