package com.myapp.service;

import com.myapp.model.Person;

import java.util.List;

/**
 * Created by Ilya Ten
 * Date: 2/9/2015
 */
public interface PersonService {
    public List<Person> people();
    public Person getPerson(long id);
    public void savePerson(Person person);
    public void deletePerson(long id);

}
