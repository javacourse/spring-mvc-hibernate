package com.myapp.dao.impl;

import com.myapp.dao.api.IPhoneDAO;
import com.myapp.model.Phone;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ilya Ten
 * Date: 2/16/2015
 */

@Repository("PhoneDAO")
@Transactional(readOnly = true)
public class PhoneDaoImpl extends AbstractHibernateDAO<Phone, Long> implements IPhoneDAO{
    @Override
    public boolean isExist(Phone entity) {
        return false;
    }
}
