package com.myapp.dao.impl;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("personDao")
@Transactional(readOnly = true)
public class PersonDaoImpl extends AbstractHibernateDAO<Person, Long> implements IPersonDAO{

	@Override
	public boolean isExist(Person entity)
	{
		return false;
	}

	
	
}
