package com.myapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DataInitializer {

	public static final int PERSON_COUNT = 3;

	@Autowired
	private IPersonDAO personDao;

	public List<Long> people = new ArrayList<Long>();

	public void initData() {
		
		people.clear();// clear out the previous list of people
		addPerson("Jim", "Smith");
		addPerson("Tina", "Marsh");
		addPerson("Steve", "Blair");

	}

	public void addPerson(String firstName, String lastName) {
		Person p = new Person();
		p.setFirstName(firstName);
		p.setLastName(lastName);

		personDao.save(p);
		people.add(p.getId());
	}

	public IPersonDAO getPersonDao()
	{
		return personDao;
	}

	public void setPersonDao(IPersonDAO personDao)
	{
		this.personDao = personDao;
	}

}
