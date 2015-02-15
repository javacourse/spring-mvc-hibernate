package com.myapp.service.api;

import com.myapp.model.Skill;

import java.util.List;

/**
 * Created by Odour on 15.02.2015.
 */
public interface ISkillService {
    public List<Skill> findAll();
    public void saveOrUpdate(Skill skill);
    public Skill getById(long id);
}
