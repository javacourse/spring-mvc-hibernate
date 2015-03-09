package com.myapp.dao.impl;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Department;
import com.myapp.model.Person;
import com.myapp.model.Phone;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	public List<Phone> getPhones(Person person) {
		return person.getPhones();
	}

	@Override
	public List<Person> peopleByDepartment(Department department) {
		return super.findByCriteria(Restrictions.eq("department", department));
	}
}
