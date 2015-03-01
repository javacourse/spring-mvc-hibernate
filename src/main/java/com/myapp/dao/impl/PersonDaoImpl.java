package com.myapp.dao.impl;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Person;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
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
            String hqlQuery = "select p from Person p join p.skills s join p.company c " +
                    "where s.id in :skillId and c.id = :companyId " +
                    "group by p.id " +
                    "having count(s.id) = :skillIdSize";

            Query query = getSession().createQuery(hqlQuery);
            query.setParameter("companyId", companyId);
            query.setParameterList("skillId", skillId);
            query.setParameter("skillIdSize", Long.valueOf(skillId.length));
            List<Person> results = query.list();

            return results;
        }
    }

    @Override
    public List<Person> findAll() {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        crit.addOrder(Order.asc("id"));

       // System.out.println(getPersistentClass());

        return crit.list();
    }
}
