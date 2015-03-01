package com.myapp.dao.impl;

import com.myapp.dao.api.IDepartmentDAO;
import com.myapp.model.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ilya Ten
 * Date: 3/1/2015
 */
@Repository("departmentDao")
@Transactional(readOnly = true)
public class DepartmentDaoImpl extends AbstractHibernateDAO<Department, Long> implements IDepartmentDAO {

    @Override
    public boolean isExist(Department entity) {
        return false;
    }
}
