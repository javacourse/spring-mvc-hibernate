package com.myapp.service;

import com.myapp.model.Department;

import java.util.List;

/**
 * Created by Ilya Ten
 * Date: 3/1/2015
 */
public interface IDepartmentService {
    public List<Department> departments();
    public Department getDepartment(long id);
    public void saveDepartment(Department department);
    public void deleteDepartment(long id);
}
