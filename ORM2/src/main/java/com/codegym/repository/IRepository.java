package com.codegym.repository;

import java.util.List;

public interface IRepository<E>{
    List<E> findAll();
    E findOneById(int id);
    void save(E e);
    void delete(int id);
}
