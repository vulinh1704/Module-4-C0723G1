package com.codegym.service;
import com.codegym.model.Student;
import java.util.List;

public interface IStudentService<E> {
    List<E> findAll();
    void save(E e);
    void delete(Long id);
}
