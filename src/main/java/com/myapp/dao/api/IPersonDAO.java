package com.myapp.dao.api;

import com.myapp.model.Person;

import java.util.List;

public interface IPersonDAO extends IGenericDAO<Person, Long>
{
    public List<Person> getByAge(int age);
}
