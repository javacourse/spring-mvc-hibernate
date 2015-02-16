package com.myapp.service;

import com.myapp.model.Person;
import com.myapp.model.Phone;

import java.util.List;
import java.util.Set;

/**
 * Created by Ilya Ten
 * Date: 2/9/2015
 */
public interface PersonService {
    public List<Person> people();
    public Person getPerson(long id);
    public void savePerson(Person person);
    public void deletePerson(long id);
    public Set<Phone> getPhones(long id);
}
