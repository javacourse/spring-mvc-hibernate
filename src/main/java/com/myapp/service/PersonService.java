package com.myapp.service;

import com.myapp.model.Person;

import java.util.List;

/**
 * Created by Toshiba on 11.02.2015.
 */
public interface PersonService {
    List<Person> findAll();
    Person getById(Long id);
    void saveOrUpdate(Person person);
}
