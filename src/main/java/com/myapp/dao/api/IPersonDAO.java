package com.myapp.dao.api;

import com.myapp.model.Company;
import com.myapp.model.Person;
import com.myapp.model.Skill;

import java.util.List;
import java.util.Set;

public interface IPersonDAO extends IGenericDAO<Person, Long> {
    public List<Person> getBySkills(Long ... id);
    public List<Person> getByCompanyAndSkills(Long companyId, Long ... skillId);
}
