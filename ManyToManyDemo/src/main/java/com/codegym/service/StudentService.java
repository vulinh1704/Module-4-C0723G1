package com.codegym.service;

import com.codegym.model.Course;
import com.codegym.model.Student;
import com.codegym.repository.CourseRepository;
import com.codegym.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService implements IStudentService<Student> {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void save(Student newStudent) {
        Set<Course> courses = newStudent.getCourses();
        if (courses != null && !courses.isEmpty()) {
            Set<Course> managedCourses = new HashSet<>();
            for (Course course : courses) {
                if (course.getId() != null) {
                    Optional<Course> optionalCourse = courseRepository.findById(course.getId());
                    optionalCourse.ifPresent(managedCourses::add);
                }
            }
            newStudent.setCourses(managedCourses);
        }
        studentRepository.save(newStudent);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

}
