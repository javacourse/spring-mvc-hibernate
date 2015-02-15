package com.myapp.service.impl;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Company;
import com.myapp.model.Person;
import com.myapp.service.api.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Odour on 12.02.2015.
 */
@Service
public class PersonService implements IPersonService{
    @Autowired
    private IPersonDAO personDao;

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public Person getById(long id) {
        return personDao.getById(id);
    }

    public void saveOrUpdate(Person person) {
        personDao.saveOrUpdate(person);
    }

    public List<Person> getByCompany(Company company) {
        return personDao.getByCompany(company);
    }
}
