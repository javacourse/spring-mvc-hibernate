package com.myapp.dao.api;

import com.myapp.model.Person;
import java.util.List;

public interface IPersonDAO extends IGenericDAO<Person, Long> {
    public List<Person> getBySkills(Long ... id);
    public List<Person> getByCompanyAndSkills(Long companyId, Long ... skillId);
}
