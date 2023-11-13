package com.codegym.service;

import java.util.List;

public interface IService<E>{
    List<E> findAll();
    int findById(int id);
    void add(E e);
    void update(int id,E e);
    void remove(int id);
    List<E> findByName(String name);
}
