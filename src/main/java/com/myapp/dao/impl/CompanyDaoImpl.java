package com.myapp.dao.impl;

import com.myapp.dao.api.ICompanyDAO;
import com.myapp.model.Company;
import com.myapp.model.Person;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Odour on 15.02.2015.
 */
@Repository("companyDao")
@Transactional(readOnly = true)
public class CompanyDaoImpl extends AbstractHibernateDAO<Company, Long> implements ICompanyDAO{

}
