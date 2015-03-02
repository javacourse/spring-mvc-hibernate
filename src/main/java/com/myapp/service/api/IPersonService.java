package com.myapp.service.api;

import com.myapp.model.Person;
import java.util.List;

/**
 * Created by Odour on 12.02.2015.
 */
public interface IPersonService {

    public List<Person> findAll();

    public Person getById(long id) throws Exception;

    public void saveOrUpdate(Person person);

    public List<Person> getByCompanyId(Long companyId) throws Exception;

    public List<Person> getBySkills(Long ... id);

    public List<Person> getByCompanyAndSkills(Long companyId, Long ... skillId) throws Exception;

    public void deleteById(Long id) throws Exception;
}
