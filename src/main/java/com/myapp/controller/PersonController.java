package com.myapp.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person/")
public class PersonController {

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

		/*for (Person per: people) {
			System.out.println(per.toString());
		}*/

		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "info")
	public ModelAndView showPersonInfo(@RequestParam(value = "id") Long id) throws Exception {
		logger.debug("Received request to show person info");
		ModelAndView mav = new ModelAndView();
		if (id == null) throw new Exception();

		Person personInfo = personService.getById(id);
		mav.addObject("personInfo", personInfo);

		mav.setViewName("person_info");

	//	System.out.println(personInfo.getCompany().getName());

		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "add")
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
	public ModelAndView editPerson(@RequestParam(value = "id") Long id) throws Exception {
		logger.debug("Received request to edit person id : " + id);

		if (id == null) throw new Exception();

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

	@RequestMapping(method = RequestMethod.POST, value = "delete")
	public String deletePerson(@RequestParam(value = "id") Long id) throws Exception {
		logger.debug("Received request to delete person id : " + id);

		if (id == null) throw new Exception();

		personService.deleteById(id);

		return "redirect:list";
	}

	@RequestMapping(method = RequestMethod.POST, value = { "add", "edit" })
	public String savePerson(@ModelAttribute("person") Person person,
							 @RequestParam(value = "compId") String companyId,
							 @RequestParam(value = "skillsVars") String[] skillsVars) throws Exception {
		logger.debug("Received postback on person " + person);

		if (person == null || companyId == null || skillsVars == null) {
			throw new Exception();
		}

		List<Skill> skillsForPerson = new ArrayList<>();

		for (String skill: skillsVars) {
			skillsForPerson.add(skillService.getById(Long.parseLong(skill)));
		}

		person.setCompany(companyService.getById(Long.parseLong(companyId)));
		person.setSkills(skillsForPerson);

		personService.saveOrUpdate(person);
		return "redirect:list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "search")
	public ModelAndView searchPerson() {
		logger.debug("Received request for person searching");
		ModelAndView model = new ModelAndView();

		List<Company> companyList = companyService.findAll();
		model.addObject("companyList", companyList);

		List<Skill> skillList = skillService.findAll();
		model.addObject("skillList", skillList);

		model.setViewName("person_search");
		return model;
	}

	@RequestMapping(method= RequestMethod.GET, value="found")
	public ModelAndView getFoundPersons(@RequestParam(value="companyId") String companyId,
										@RequestParam(value="skillsId", required=false) String ... skillsId) throws Exception {
		logger.debug("Received request for getting found persons list");

		if (companyId == null) throw new Exception();

		ModelAndView model = new ModelAndView();
		List<Person> personList;

		if (skillsId != null) {
			Long[] skillsIdParams = new Long[skillsId.length];

			for (int i = 0; i < skillsIdParams.length; i++) {
				skillsIdParams[i] = Long.parseLong(skillsId[i]);
			}


			personList = personService.getByCompanyAndSkills(Long.parseLong(companyId), skillsIdParams);
		} else {
			personList = personService.getByCompanyId(Long.parseLong(companyId));
		}

		model.addObject("personList", personList);

		model.setViewName("person_found");
		return model;
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
