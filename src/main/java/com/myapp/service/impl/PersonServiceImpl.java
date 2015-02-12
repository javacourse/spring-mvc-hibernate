package com.myapp.service.impl;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Person;
import com.myapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Toshiba on 11.02.2015.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private IPersonDAO personDao;

    @Transactional
    public List<Person> findAll(){
        return   personDao.findAll();
    }
    public Person getById(Long id){
        return personDao.getById(id);
    }
    public void saveOrUpdate(Person person){
         personDao.saveOrUpdate(person);
    }
}
