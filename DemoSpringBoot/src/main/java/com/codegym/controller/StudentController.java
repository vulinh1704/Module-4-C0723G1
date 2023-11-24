package com.codegym.controller;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {
    @Autowired
    private IService<Student> studentService;

    @Autowired
    private IService<ClassRoom> classRoomIService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Student> add(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        studentService.delete(Math.toIntExact(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> add(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> getByName(@RequestParam String name) {
        List<Student> students = (List<Student>) studentService.findByNameContain(name);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
