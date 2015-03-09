package com.myapp.controller;

import com.myapp.model.Department;
import com.myapp.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Ilya Ten
 * Date: 3/1/2015
 */
@Controller
@RequestMapping("/department/")
public class DepartmentController {
    private static final Logger logger = LoggerFactory
            .getLogger(DepartmentController.class);

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping(method = RequestMethod.GET, value = "deptList")
    public ModelAndView listDepartments()
    {
        logger.debug("Received request to list departments");
        ModelAndView mav = new ModelAndView();
        List<Department> departments = departmentService.departments();
        logger.debug("Departments count = " + departments.size());
        mav.addObject("departments", departments);
        mav.setViewName("deptList");
        return mav;

    }

    @RequestMapping(method = RequestMethod.GET, value = "new")
    public ModelAndView addDepartment()
    {
        logger.debug("Received request to add new department ");
        ModelAndView mav = new ModelAndView();
        Department department = departmentService.getDepartment(-1);
        mav.addObject("department", department);

        mav.setViewName("addDept");
        return mav;

    }

    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public ModelAndView editDepartment(@RequestParam(value = "id") Long id)
    {
        logger.debug("Received request to edit department id : " + id);
        ModelAndView mav = new ModelAndView();
        Department department = departmentService.getDepartment(id);
        mav.addObject("department", department);

        mav.setViewName("editDept");
        return mav;

    }

    @RequestMapping(method = RequestMethod.POST, value = { "new", "edit" })
    public String saveDepartment(@ModelAttribute("department") Department department)
    {
        logger.debug("Received postback on department " + department);
        departmentService.saveDepartment(department);
        return "redirect:deptList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "del")
    public String deleteDepartment(@RequestParam(value = "id") Long id)
    {
        logger.debug("Received request to delete department id : " + id);
        departmentService.deleteDepartment(id);
        return "redirect:deptList";
    }

    @RequestMapping(method = RequestMethod.GET, value = "editPeople")
    public ModelAndView editPeople(@RequestParam(value = "id") Long id) {
        logger.debug("Received request to modify stuff of current department");
        ModelAndView mav = new ModelAndView();
        Department department = departmentService.getDepartment(id);
        mav.addObject("department", department);
        mav.addObject("deptId", id);
        mav.setViewName("list");
        return mav;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception ex)
    {

        logger.warn(ClassUtils.getShortName(ex.getClass()) + " -- "
                + ex.getMessage());
        return ex.getMessage();
    }

    public IDepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
