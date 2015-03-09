package com.myapp.service;

import com.myapp.model.Department;
import com.myapp.model.Person;
import com.myapp.model.Phone;

import java.util.List;

/**
 * Created by Ilya Ten
 * Date: 2/9/2015
 */
public interface PersonService {
    public List<Person> peopleByDepartment(Department department);
    public Person newPerson();
    public Person getPerson(long id);
    public void savePerson(Person person);
    public void deletePerson(long id);
    public List<Phone> getPhones(long id);
}
