package com.myapp.controller;

import com.myapp.model.Skill;
import com.myapp.service.api.ISkillService;
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
@RequestMapping(value = "/skill")
public class SkillController {

    private static final Logger logger = LoggerFactory
            .getLogger(SkillController.class);

    @Autowired
    private ISkillService skillService;

    @RequestMapping(method = RequestMethod.GET, value = "list")
    public ModelAndView listSkills() {
        logger.debug("Received request to list skills");
        ModelAndView model = new ModelAndView();

        List<Skill> skills = skillService.findAll();
        model.addObject("skills", skills);
        model.setViewName("skill_list");

        return model;
    }

    @RequestMapping(method = RequestMethod.GET, value = "add")
    public ModelAndView addSkill() {
        logger.debug("Received request to add new skill");
        ModelAndView model = new ModelAndView();

        Skill skill = new Skill();
        model.addObject("skill", skill);
        model.setViewName("skill_add");

        return model;
    }

    @RequestMapping(method = RequestMethod.GET, value = "info")
    public ModelAndView showSkillInfo(@RequestParam(value = "id") Long skillId) throws Exception {
        if (skillId == null) throw new Exception();
        ModelAndView mav = new ModelAndView();

        Skill skill = skillService.getById(skillId);
        mav.addObject(skill);

        mav.setViewName("skill_info");

        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "edit")
    public ModelAndView editSkill(@RequestParam(value = "id") long id) {
        logger.debug("Received request to edit");
        ModelAndView model = new ModelAndView();
        Skill skill = skillService.getById(id);

        model.addObject("skill", skill);
        model.setViewName("skill_edit");

        return model;
    }

    @RequestMapping(method = RequestMethod.POST, value = {"add", "edit"})
    public String saveSkill(@ModelAttribute(value = "skill") Skill skill) {
        logger.debug("Received postback on skill " + skill);
        skillService.saveOrUpdate(skill);

        return "redirect:list";
    }
}
