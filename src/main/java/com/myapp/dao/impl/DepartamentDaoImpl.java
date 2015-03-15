package com.myapp.dao.impl;

import com.myapp.dao.api.IDepartamentDAO;
import com.myapp.model.Departament;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("departamentDao")
@Transactional(readOnly = true)
public class DepartamentDaoImpl extends AbstractHibernateDAO<Departament, Long> implements IDepartamentDAO {

    @Override
    public boolean isExist(Departament entity)
    {
        return false;
    }

    }
