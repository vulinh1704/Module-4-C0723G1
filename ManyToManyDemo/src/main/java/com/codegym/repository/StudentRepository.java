package com.codegym.repository;

import com.codegym.model.Course;
import com.codegym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCoursesIn(List<Course> courses);
}
