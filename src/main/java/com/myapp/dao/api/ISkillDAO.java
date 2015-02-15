package com.myapp.dao.api;

import com.myapp.model.Skill;

import java.util.List;
import java.util.Set;

/**
 * Created by Odour on 15.02.2015.
 */
public interface ISkillDAO extends IGenericDAO<Skill,Long> {
    public List<Skill> getByName(String name);
    public List<Skill> getByPersonName(String personName);
}
