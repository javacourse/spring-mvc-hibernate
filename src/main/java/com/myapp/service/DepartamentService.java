package com.myapp.service;

import com.myapp.model.Departament;

import java.util.List;

/**
 * Created by ragham on 11.02.2015.
 */

public interface DepartamentService {
    public List<Departament> list();
    public Departament getDepartament(long id);
    public void saveDepartament(Departament departament);
    public void deleteDepartament(long id);
}

