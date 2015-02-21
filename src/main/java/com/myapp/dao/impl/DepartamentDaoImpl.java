package com.myapp.dao.impl;

import com.myapp.dao.api.IDepartamentDAO;
import com.myapp.model.Departament;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("departamentDao")
@Transactional(readOnly = true)
public class DepartamentDaoImpl extends AbstractHibernateDAO<Departament, Long> implements IDepartamentDAO {

    @Override
    public boolean isExist(Departament entity)
    {
        return false;
    }

    /*@Override
    public List<Departament> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }*/
    public List<Departament> getCustomersByCriteria(String str) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        //Criteria criteria = session.createCriteria(Departament.class).add(Restrictions.eq("volume", 10000));
        criteria.add(Restrictions.like("depName", "%" + str + "%").ignoreCase());
        //criteria.add(Expression.ge("date",startDate));
        //criteria.add(Restrictions.like("tin", "%" + opts.getTin() + "%"));

        return ((List <Departament>) criteria.list());
    }
}
