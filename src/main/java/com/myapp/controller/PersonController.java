package com.myapp.controller;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Departament;
import com.myapp.model.Person;
import com.myapp.service.DepartamentService;
import com.myapp.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/person/")
public class PersonController
{
	private static final Logger logger = LoggerFactory
			.getLogger(PersonController.class);

	private PersonService personService;
	private DepartamentService departamentService;
	@Autowired
	private IPersonDAO personDao;

	@Autowired
	public PersonController(PersonService personService, DepartamentService departamentService) {
		this.personService = personService;
		this.departamentService = departamentService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView listPeople()
	{
		logger.debug("Received request to list persons");
		ModelAndView mav = new ModelAndView();
		List<Person> people = personService.people();
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
		Person person = personService.getPerson(-1);
		mav.addObject("person", person);

		List<Departament> departaments = departamentService.list();

		mav.addObject("departaments", departaments);
		mav.addObject("test", "testtest1111");
		mav.setViewName("add");
		return mav;
	}
	@RequestMapping(method = RequestMethod.GET, value = "edit")
	public ModelAndView editPerson(@RequestParam(value = "id") Long id)
	{
		logger.debug("Received request to edit person id : " + id);

		ModelAndView mav = new ModelAndView();
		Person person = personService.getPerson(id);

		logger.debug("Received request person.Id= " + person.getId()+" getFirstName= " + person.getFirstName() + " departament  = " +person.getDepartament().getDepName());

		mav.addObject("person", person);

		List<Departament> departaments = departamentService.list();
		mav.addObject("departaments", departaments);

		mav.setViewName("edit");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = { "new", "edit" })
	public String savePerson(@ModelAttribute("person") Person person,
							 @RequestParam(value = "departamentId") String departamentId) {
		logger.debug("Received postback on person " + person);

		person.setDepartament(departamentService.getDepartament(Long.parseLong(departamentId)));

		personService.savePerson(person);
		return "redirect:list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "search")
	public ModelAndView searchPerson() {
		logger.debug("Received request for person searching");
		ModelAndView model = new ModelAndView();
		List<Departament> departaments = departamentService.list();
		model.addObject("departaments", departaments);
		model.setViewName("search");
		return model;
	}

	@RequestMapping(method= RequestMethod.GET, value="found")
	public ModelAndView getFoundPersons(@RequestParam(value="departamentId") String departamentId){
		logger.debug("Received request for getting found persons list");
		ModelAndView model = new ModelAndView();
		List<Person> people;
		people = personService.getByDepartamentId(Long.parseLong(departamentId));
		model.addObject("people", people);
		model.setViewName("found");
		return model;
	}

	@RequestMapping(method = RequestMethod.GET, value = "del")
	public String deletePerson(@RequestParam(value = "id") Long id)
	{
		logger.debug("Received request to delete person id : " + id);
		personService.deletePerson(id);
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