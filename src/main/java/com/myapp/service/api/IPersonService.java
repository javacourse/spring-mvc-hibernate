package com.myapp.service.api;

import com.myapp.model.Person;
import java.util.List;

/**
 * Created by Odour on 12.02.2015.
 */
public interface IPersonService {

    public List<Person> findAll();

    public Person getById(long id);

    public void saveOrUpdate(Person person);

    public List<Person> getByCompanyId(Long companyId);

    public List<Person> getBySkills(Long ... id);

    public List<Person> getByCompanyAndSkills(Long companyId, Long ... skillId);

    public void deleteById(Long id);
}
