package com.myapp.controller;
import com.myapp.dao.api.IDepartamentDAO;
import com.myapp.model.Departament;
import com.myapp.service.DepartamentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/department/")
public class DepartamentController
{
    private static final Logger logger = LoggerFactory
            .getLogger(DepartamentController.class);
    @Autowired
    private IDepartamentDAO departamentDao;
    @Autowired
    private DepartamentService departamentService;
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public ModelAndView listofDepartament()
    {
        logger.debug("Received request to list of departments");
        ModelAndView mav = new ModelAndView();
        List<Departament> list = departamentService.list();
        logger.debug("department Listing count = " + list.size());
        mav.addObject("list", list);
        mav.setViewName("listofdepartaments");
        return mav;
    }
    @RequestMapping(method = RequestMethod.GET, value = "new")
    public ModelAndView addDepartament()
    {
        logger.debug("Received request to add new departament ");
        ModelAndView mav = new ModelAndView();
        Departament departament = departamentService.getDepartament(-1);
        mav.addObject("departament", departament);
        mav.setViewName("add_dep");
        return mav;
    }
    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public ModelAndView editDepartament(@RequestParam(value = "id") Long id)
    {
        logger.debug("Received request to edit departament id : " + id);
        ModelAndView mav = new ModelAndView();
        Departament departament = departamentService.getDepartament(id);
        mav.addObject("departament", departament);
        mav.setViewName("edit_dep");
        logger.debug("Received postback on departament debug " + departament);
        return mav;
    }
    @RequestMapping(method = RequestMethod.POST, value = { "new", "edit" })
    public String saveDepartament(@ModelAttribute("departament") Departament departament)
    {
        logger.debug("Received postback on departament " + departament);
        departamentService.saveDepartament(departament);
        return "redirect:list";
    }
    @RequestMapping(method = RequestMethod.GET, value = "del")
    public String deleteDepartament(@RequestParam(value = "id") Long id)
    {
        logger.debug("Received request to delete departament id : " + id);
        departamentService.deleteDepartament(id);
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
    public IDepartamentDAO getDepartamentDao()
    {
        return departamentDao;
    }
    public void setDepartamentDao(IDepartamentDAO departamentDao)
    {
        this.departamentDao = departamentDao;
    }
}