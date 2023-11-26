package com.codegym.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String image;

    private int age;

    private String email;

    @ManyToOne
    private ClassRoom classRoom;


}
