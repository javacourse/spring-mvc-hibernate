package com.myapp.dao.api;

import com.myapp.model.Person;
import com.myapp.model.Phone;

import java.util.Set;

public interface IPersonDAO extends IGenericDAO<Person, Long>
{
    public Set<Phone> getPhones(Person person);

}
