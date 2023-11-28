package com.codegym.controller;

import com.codegym.model.Course;
import com.codegym.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity<>(this.courseService.getCourse(), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Course course) {
        this.courseService.add(course);
        return new ResponseEntity<>("DOne", HttpStatus.OK);
    }
}
