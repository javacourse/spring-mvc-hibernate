package com.myapp.dao.api;

import com.myapp.model.Department;
import com.myapp.model.Person;
import com.myapp.model.Phone;

import java.util.List;

public interface IPersonDAO extends IGenericDAO<Person, Long>
{
    public List<Phone> getPhones(Person person);
    public List<Person> peopleByDepartment(Department department);

}
