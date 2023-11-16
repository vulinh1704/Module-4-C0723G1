package com.codegym.model;

import java.util.ArrayList;
import java.util.List;

public class Girl {
    private int id = 1;
    private String name;
    private String image;

    public Girl(int id, String name, String image) {
        this();
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Girl() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public static void main(String[] args) {
//        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        System.out.println(numbers.get(0));

//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }

//        numbers.set(1, 3);
//        numbers.remove(0);
//        for (Integer item: numbers) {
//            System.out.println(item);
//        }

//        List<Girl> list = new ArrayList<>();
//        list.add(new Girl(1, "Linh", "ac.jpg"));
//        list.add(new Girl(2, "A", "abc.jpg"));

//        Girl girlCity = new Girl(3, "C", "d.jpg");
//        list.set(1, girlCity);
//        list.remove(1);
//        for (Girl item: list) {
//            System.out.println(item);
//        }
    }
}



