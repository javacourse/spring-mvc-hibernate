package com.myapp.dao.impl;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Company;
import com.myapp.model.Person;
import com.myapp.model.Skill;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository("personDao")
@Transactional(readOnly = true)
public class PersonDaoImpl extends AbstractHibernateDAO<Person, Long> implements IPersonDAO {

    @Override
    public List<Person> getBySkill(long id) {

        String hqlQuery = "select p from Person p join p.skills s where s.id = :id";
        Query query = getSession().createQuery(hqlQuery);
        query.setParameter("id", id);
        List results = query.list();

        return results;
    }
}
