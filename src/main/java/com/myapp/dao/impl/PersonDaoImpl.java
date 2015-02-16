package com.myapp.dao.impl;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Person;
import com.myapp.model.Phone;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository("personDao")
@Transactional(readOnly = true)
public class PersonDaoImpl extends AbstractHibernateDAO<Person, Long> implements IPersonDAO{

	@Override
	public boolean isExist(Person entity)
	{
		
//		return !findByCriteria(Restrictions.eq("name", entity.getName())).isEmpty();
		return false;
	}


	@Override
	public Set<Phone> getPhones(Person person) {
		return person.getPhones();
	}
}
