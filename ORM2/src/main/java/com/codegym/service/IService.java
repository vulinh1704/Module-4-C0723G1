package com.codegym.service;

import java.util.List;

public interface IService<E> {
    List<E> findAll();
    E findOneById(int id);
    void save(E e);
    void delete(int id);
}
