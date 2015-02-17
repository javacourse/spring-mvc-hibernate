package com.myapp.dao.impl;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Person;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("personDao")
@Transactional(readOnly = true)
public class PersonDaoImpl extends AbstractHibernateDAO<Person, Long> implements IPersonDAO {

    @Override
    public List<Person> getBySkills(Long ... id) {
        if (id.length == 0) {
            return new ArrayList<Person>();
        } else {
            String hqlQuery = "select distinct p from Person p join p.skills s where s.id in :id";

            Query query = getSession().createQuery(hqlQuery);
            query.setParameterList("id", id);
            List results = query.list();

            return results;
        }
    }

    @Override
    public List<Person> getByCompanyAndSkills(Long companyId, Long ... skillId) {
        if (skillId.length == 0) {
            String hqlQuery = "select distinct p from Person p join p.skills s join p.company c where c.id = :companyId";

            Query query = getSession().createQuery(hqlQuery);
            query.setParameter("companyId", companyId);
            List results = query.list();

            return results;
        } else {
            String hqlQuery = "select distinct p from Person p join p.skills s join p.company c where c.id = :companyId and s.id in :skillId";

            Query query = getSession().createQuery(hqlQuery);
            query.setParameter("companyId", companyId);
            query.setParameterList("skillId", skillId);
            List results = query.list();

            return results;
        }
    }
}
