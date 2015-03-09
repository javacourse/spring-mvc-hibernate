package com.myapp.controller;

import com.myapp.model.Department;
import com.myapp.model.Person;
import com.myapp.model.Phone;
import com.myapp.service.IDepartmentService;
import com.myapp.service.PersonService;
import com.myapp.service.PhoneService;
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

	@Autowired
	private PersonService personService;
	@Autowired
	private PhoneService phoneService;

	private IDepartmentService departmentService;

	@Autowired
	public PersonController(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView listPeople(@RequestParam(value = "deptId") Long deptId)
	{
		logger.debug("Received request to list persons");
		ModelAndView mav = new ModelAndView();
		Department department = departmentService.getDepartment(deptId);
		List<Person> people = personService.peopleByDepartment(department);
		logger.debug("Person Listing count = " + people.size());
		mav.addObject("department", department);
		mav.setViewName("list");
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "addPhone")
	public ModelAndView addPhone(@RequestParam(value = "id") Long id) {
		logger.debug("Received request to add new phone for a person ");
		ModelAndView mav = new ModelAndView();
		Person person = personService.getPerson(id);
		mav.addObject("person", person);
		Phone phone = phoneService.newPhone(person);
		mav.addObject("phone", phone);
		mav.setViewName("addPhone");
		return mav;
	}


	@RequestMapping(method = RequestMethod.GET, value = "new")
	public ModelAndView addPerson()
	{
		logger.debug("Received request to add new person ");
		ModelAndView mav = new ModelAndView();
		Person person = personService.newPerson();
		mav.addObject("person", person);
		mav.setViewName("add");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "edit")
	public ModelAndView editPerson(@RequestParam(value = "id") Long id)
	{
		logger.debug("Received request to edit person id : " + id);
		ModelAndView mav = new ModelAndView();
		Person person = personService.getPerson(id);
		mav.addObject("person", person);

		mav.setViewName("edit");
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST, value = {"new","edit"})
	public String savePerson(@ModelAttribute("person") Person person, @RequestParam(value = "deptId") Long deptId)
	{
		logger.debug("Received postback on person " + person);
		Department department = departmentService.getDepartment(deptId);
		person.setDepartment(department);
		personService.savePerson(person);
		return "redirect:list?deptId=" + deptId;
	}

	@RequestMapping(method = RequestMethod.GET, value = "del")
	public String deletePerson(@RequestParam(value = "id") Long id, @RequestParam(value = "deptId") Long deptId)
	{
		logger.debug("Received request to delete person id : " + id);
		personService.deletePerson(id);
		return "redirect:list?deptId=" + deptId;
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception ex)
	{

		logger.warn(ClassUtils.getShortName(ex.getClass()) + " -- "
				+ ex.getMessage());
		return ex.getMessage();
	}

	public PhoneService getPhoneService() {
		return phoneService;
	}

	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}
}
