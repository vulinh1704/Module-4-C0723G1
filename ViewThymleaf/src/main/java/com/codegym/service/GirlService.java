package com.codegym.service;

import com.codegym.model.Girl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class GirlService implements IService<Girl> {
    private List<Girl> girlList = new ArrayList<>();


    @Override
    public List<Girl> findAll() {
        return girlList;
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < girlList.size(); i++) {
            if(id == girlList.get(i).getId()) return i;
        }
        return -1;
    }

    @Override
    public void add(Girl girl) {
        girlList.add(girl);
    }

    @Override
    public void update(int id, Girl girl) {
        int index = findById(id);
        girlList.set(index, girl);
    }

    @Override
    public void remove(int id) {
        int index = findById(id);
        girlList.remove(index);
    }

    @Override
    public List<Girl> findByName(String name) {
        List<Girl> girls = new ArrayList<>();
        for (Girl girl: girlList) {
            if(girl.getName().toUpperCase().contains(name.toUpperCase())) girls.add(girl);
        }
        return girls;
    }

    public Girl findGirlById(int id) {
        return this.girlList.get(findById(id));
    }
}
