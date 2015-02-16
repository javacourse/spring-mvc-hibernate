package com.myapp.service.impl;

import com.myapp.dao.api.ICompanyDAO;
import com.myapp.dao.api.IPersonDAO;
import com.myapp.dao.api.ISkillDAO;
import com.myapp.model.Company;
import com.myapp.model.Person;
import com.myapp.model.Skill;
import com.myapp.service.api.IPersonService;
import org.hibernate.criterion.Restrictions;
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

    @Autowired
    private ICompanyDAO companyDao;

    @Autowired
    private ISkillDAO skillDao;

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public Person getById(long id) {
        return personDao.getById(id);
    }

    public void saveOrUpdate(Person person) {
        personDao.saveOrUpdate(person);
    }

    public List<Person> getByCompanyId(Long companyId) {
        Company company = companyDao.getById(companyId);
        return personDao.findByCriteria(Restrictions.eq("company", company));
    }
}
