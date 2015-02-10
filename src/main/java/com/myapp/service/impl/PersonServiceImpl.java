package com.myapp.service.impl;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Person;
import com.myapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ilya Ten
 * Date: 2/9/2015
 */
@Service
public class PersonServiceImpl implements PersonService {
    private IPersonDAO personDao;

    @Autowired
    public PersonServiceImpl(IPersonDAO personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> people() {
        return personDao.findAll();
    }

    @Override
    public Person getPerson(long id) {
        if (id < 0) {
            return new Person();
        }
        return personDao.getById(id);
    }

    @Override
    public void savePerson(Person person) {
        personDao.saveOrUpdate(person);
    }
}
