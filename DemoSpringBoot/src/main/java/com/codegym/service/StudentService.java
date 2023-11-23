package com.codegym.service;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IService<Student> {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findOneById(Long id) {
        return studentRepository.findById(Math.toIntExact(id));
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findByNameContain(String name) {
        return studentRepository.findByNameContaining(name);
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findByIdCustom(id);
    }

    public List<Student> findByClassroom(ClassRoom classRoom) {
        return studentRepository.findByClassRoom(classRoom);
    }

}
