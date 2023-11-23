package com.codegym.repository;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContaining(String name);

    @Query(value = "select * from student where id = :id", nativeQuery = true)
    Student findByIdCustom(@Param("id") int id);

    List<Student> findByClassRoom(ClassRoom classRoom);
}

// CRUD, hàm truy vấn, 2 bảng, converter or fomater
