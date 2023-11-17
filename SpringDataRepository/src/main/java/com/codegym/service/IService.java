package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;
import java.util.Optional;

public interface IService<E> {
    Iterable<E> findAll();
    Optional<E> findOneById(int id);
    void save(E e);
    void delete(int id);
    List<E> findByNameContain(String name);
    E findStudentById(int id);
}
