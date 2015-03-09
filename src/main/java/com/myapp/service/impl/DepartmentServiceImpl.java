package com.myapp.service.impl;

import com.myapp.dao.api.IDepartmentDAO;
import com.myapp.model.Department;
import com.myapp.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ilya Ten
 * Date: 3/1/2015
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private IDepartmentDAO departmentDAO;
    @Autowired
    public DepartmentServiceImpl(IDepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public List<Department> departments() {
        return departmentDAO.findAll();
    }

    @Override
    public Department getDepartment(long id) {
        if (id < 0) {
            return new Department();
        }
        return departmentDAO.getById(id);
    }

    @Override
    public void saveDepartment(Department department) {
        departmentDAO.saveOrUpdate(department);
    }

    @Override
    public void deleteDepartment(long id) {
        departmentDAO.deleteById(id);
    }
}
