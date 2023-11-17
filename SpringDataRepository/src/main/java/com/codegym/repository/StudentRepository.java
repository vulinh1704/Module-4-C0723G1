package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContaining(String name);

    @Query(value = "select * from student where id = :id", nativeQuery = true)
    Student findByIdCustom(@Param("id") int id);
}

// CRUD, hàm truy vấn, 2 bảng, converter or fomater
