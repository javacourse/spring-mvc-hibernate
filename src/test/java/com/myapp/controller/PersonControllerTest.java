package com.myapp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.myapp.dao.impl.DataInitializer;
import com.myapp.model.Person;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration({"/db.xml", "file:servlet-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional()
@Ignore
public class PersonControllerTest
{

	@Autowired
	private DataInitializer dataInitializer;


	@Autowired
	private PersonController personController;

	@Before
	public void before()
	{
		dataInitializer.initData();
	}

	@Test
	public void shouldReturnPersonListView()
	{
		ModelAndView mav = personController.listPeople();
		assertEquals("list", mav.getViewName());

		@SuppressWarnings("unchecked")
		List<Person> people = (List<Person>) mav.getModelMap().get("people");
		assertNotNull(people);
		assertEquals(DataInitializer.PERSON_COUNT, people.size());
	}

	@Test
	public void shouldReturnNewPersonWithAddMav()
	{
		ModelAndView mav = personController.addPerson();
		assertNotNull(mav);
		assertEquals("add", mav.getViewName());
		Object object = mav.getModel().get("person");
		assertTrue(Person.class.isAssignableFrom(object.getClass()));
		Person person = (Person) object;
		assertNull(person.getId());
		assertNull(person.getFirstName());
		assertNull(person.getLastName());
	}

	@Test
	public void shouldReturnSecondPersonWithEditMav()
	{

		Long templateId = dataInitializer.people.get(1);
		ModelAndView mav = personController.editPerson(templateId);
		assertNotNull(mav);
		assertEquals("edit", mav.getViewName());
		Object object = mav.getModel().get("person");
		assertTrue(Person.class.isAssignableFrom(object.getClass()));
		Person person = (Person) object;
		assertEquals(templateId, person.getId());
	}

}
