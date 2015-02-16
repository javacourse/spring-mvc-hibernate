package com.myapp.service.impl;
import com.myapp.dao.api.IDepartamentDAO;
import com.myapp.model.Departament;
import com.myapp.service.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by ragham
 * Date: 2/9/2015
 */
@Service
public class DepartamentServiceImpl implements DepartamentService {
    private IDepartamentDAO departamentDao;
    @Autowired
    public DepartamentServiceImpl(IDepartamentDAO departamentDao) {
        this.departamentDao = departamentDao;
    }
    @Override
    public List<Departament> list() {
        return departamentDao.findAll();
    }
    @Override
    public Departament getDepartament(long id) {
        if (id < 0) {
            return new Departament();
        }
        return departamentDao.getById(id);
    }
    @Override
    public void saveDepartament(Departament departament) {
        departamentDao.saveOrUpdate(departament);
    }
    @Override
    public void deleteDepartament(long id) {
        departamentDao.deleteById(id);
    }
}