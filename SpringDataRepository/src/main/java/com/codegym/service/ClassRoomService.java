package com.codegym.service;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClassRoomService implements IService<ClassRoom> {

    @Autowired
    private ClassRoomRepository classRoomRepository;


//    public ClassRoomService(ClassRoomRepository classroomRepository){
//        this.classroomRepository = classroomRepository;
//    }

    @Override
    public Iterable<ClassRoom> findAll() {
        return null;
    }

    @Override
    public Optional<ClassRoom> findOneById(Long id) {
        return classRoomRepository.findById( id);
    }

    @Override
    public void save(ClassRoom classRoom) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ClassRoom> findByNameContain(String name) {
        return null;
    }

    @Override
    public ClassRoom findStudentById(int id) {
        return null;
    }

    @Override
    public List<Student> findByClassroom(ClassRoom classRoom) {
        return null;
    }

}
