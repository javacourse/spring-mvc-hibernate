package com.myapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.myapp.dao.api.IPersonDAO;
import com.myapp.model.Company;
import com.myapp.model.Person;
import com.myapp.model.Skill;
import com.myapp.service.api.ICompanyService;
import com.myapp.service.api.IPersonService;
import com.myapp.service.api.ISkillService;
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

	private IPersonService personService;
	private ICompanyService companyService;
	private ISkillService skillService;

	@Autowired
	public PersonController(IPersonService personService, ICompanyService companyService, ISkillService skillService) {
		this.personService = personService;
		this.companyService = companyService;
		this.skillService = skillService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView listPeople()
	{
		logger.debug("Received request to list persons");
		ModelAndView mav = new ModelAndView();
		List<Person> people = personService.findAll();
		logger.debug("Person Listing count = " + people.size());
		mav.addObject("people", people);
		mav.setViewName("person_list");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "new")
	public ModelAndView addPerson()
	{
		logger.debug("Received request to add new person ");
		ModelAndView mav = new ModelAndView();
		Person person = new Person();
		mav.addObject("person", person);

		List<Company> companies = companyService.findAll();
		mav.addObject("companies", companies);

		List<Skill> skills = skillService.findAll();
		mav.addObject("skillsList", skills);

		mav.setViewName("person_add");
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET, value = "edit")
	public ModelAndView editPerson(@RequestParam(value = "id") Long id)
	{
		logger.debug("Received request to edit person id : " + id);
		ModelAndView mav = new ModelAndView();
		Person person = personService.getById(id);
		mav.addObject("person", person);

		List<Company> companies = companyService.findAll();
		mav.addObject("companies", companies);

		List<Skill> skills = skillService.findAll();
		mav.addObject("skillsList", skills);

		mav.setViewName("person_edit");
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST, value = { "new", "edit" })
	public String savePerson(@ModelAttribute("person") Person person, @RequestParam(value = "compId") String companyId, @RequestParam(value = "skillsVars") String[] skillsVars)
	{
		logger.debug("Received postback on person " + person);

		List<Skill> skillsForPerson = new ArrayList<>();

		for (String skill: skillsVars) {
			System.out.println(skillsVars);
			skillsForPerson.add(skillService.getById(Long.parseLong(skill)));
		}

		person.setCompany(companyService.getById(Long.parseLong(companyId)));
		person.setSkills(skillsForPerson);

		personService.saveOrUpdate(person);
		return "redirect:list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "by_company")
	@ResponseBody
	public String showByCompany() {
		StringBuilder strB = new StringBuilder();

		List<Person> persons = personService.getByCompanyId((long) 2);

		for (Person pers: persons) {
			strB.append(pers.toString() + "</br>");
		}

		return strB.toString();
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleException(Exception ex)
	{

		logger.warn(ClassUtils.getShortName(ex.getClass()) + " -- "
				+ ex.getMessage());
		return ex.getMessage();
	}
}
