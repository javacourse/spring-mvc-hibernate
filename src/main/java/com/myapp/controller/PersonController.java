package com.myapp.controller;

import java.util.List;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person/")
public class PersonController
{

	private static final Logger logger = LoggerFactory
			.getLogger(PersonController.class);

	@Autowired
	private IPersonDAO personDao;

	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView listPeople()
	{
		logger.debug("Received request to list persons");
		ModelAndView mav = new ModelAndView();
		List<Person> people = personDao.findAll();
		logger.debug("Person Listing count = " + people.size());
		mav.addObject("people", people);
		mav.setViewName("list");
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "new")
	public ModelAndView addPerson()
	{
		logger.debug("Received request to add new person ");
		ModelAndView mav = new ModelAndView();
		Person person = new Person();
		mav.addObject("person", person);

		mav.setViewName("add");
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "edit")
	public ModelAndView editPerson(@RequestParam(value = "id") Long id)
	{
		logger.debug("Received request to edit person id : " + id);
		ModelAndView mav = new ModelAndView();
		Person person = personDao.getById(id);
		mav.addObject("person", person);

		mav.setViewName("edit");
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST, value = { "new", "edit" })
	public String savePerson(@ModelAttribute("person") Person person)
	{
		logger.debug("Received postback on person " + person);
		personDao.saveOrUpdate(person);
		return "redirect:list";
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception ex)
	{

		logger.warn(ClassUtils.getShortName(ex.getClass()) + " -- "
				+ ex.getMessage());
		return ex.getMessage();
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
