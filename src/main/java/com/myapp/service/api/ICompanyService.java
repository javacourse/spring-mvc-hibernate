package com.myapp.service.api;

import com.myapp.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Odour on 15.02.2015.
 */
public interface ICompanyService {
    public List<Company> findAll();
    public void saveOrUpdate(Company company);
    public Company getById(long id);
}
