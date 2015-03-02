package com.myapp.service.impl;

import com.myapp.dao.api.ISkillDAO;
import com.myapp.model.Skill;
import com.myapp.service.api.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Odour on 15.02.2015.
 */
@Service
public class SkillService implements ISkillService {

    @Autowired
    private ISkillDAO skillDao;

    public List<Skill> findAll() {
        return skillDao.findAll();
    }

    public void saveOrUpdate(Skill skill) {
        skillDao.saveOrUpdate(skill);
    }

    public Skill getById(long id) throws Exception {
        if (!skillDao.isExistById(id)) throw new Exception();
        return skillDao.getById(id);
    }
}
