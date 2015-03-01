package com.myapp.service.impl;

import com.myapp.dao.api.ICompanyDAO;
import com.myapp.model.Company;
import com.myapp.service.api.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Odour on 15.02.2015.
 */
@Service
public class CompanyService implements ICompanyService{

    @Autowired
    private ICompanyDAO companyDao;

    public List<Company> findAll() {
        return companyDao.findAll();
    }

    public void saveOrUpdate(Company company) {
        companyDao.saveOrUpdate(company);
    }

    public Company getById(Long id) {
        return companyDao.getById(id);
    }
}
