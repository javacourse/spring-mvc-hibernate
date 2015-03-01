package com.myapp.controller;

import com.myapp.model.Company;
import com.myapp.service.api.ICompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Odour on 15.02.2015.
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    private static final Logger logger = LoggerFactory
            .getLogger(CompanyController.class);

    @Autowired
    private ICompanyService companyService;

    @RequestMapping(method = RequestMethod.GET, value = "list")
    public ModelAndView listCompanies() {
        logger.debug("Received request to list companies");
        ModelAndView model = new ModelAndView();

        List<Company> companies = companyService.findAll();
        logger.debug("Person Listing count = " + companies.size());
        model.addObject("companies", companies);
        model.setViewName("company_list");

        return model;
    }

    @RequestMapping(method = RequestMethod.GET, value="info")
    public ModelAndView showCompanyInfo(@RequestParam(value = "id") Long companyId) throws Exception {
        if (companyId == null) throw new Exception();

        ModelAndView mav = new ModelAndView();

        Company company = companyService.getById(companyId);
        mav.addObject("company", company);
        mav.setViewName("company_info");

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "add")
    public ModelAndView addCompany() {
        logger.debug("Received request to add new company");
        ModelAndView model = new ModelAndView();
        Company company = new Company();

        model.addObject("company", company);
        model.setViewName("company_add");

        return model;
    }

    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public ModelAndView editCompany(@RequestParam(value = "id") Long id) throws Exception {
        logger.debug("Received request to edit company id : " + id);
        if (id == null) throw new Exception();
        ModelAndView model = new ModelAndView();

        Company company = companyService.getById(id);
        model.addObject("company", company);

        model.setViewName("company_edit");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = {"add", "edit"})
    public String saveCompany(@ModelAttribute("company") Company company) {
        logger.debug("Received postback on company " + company);
        companyService.saveOrUpdate(company);

        return "redirect:list";
    }
}
