package com.myapp.service.impl;

import com.myapp.dao.api.IPhoneDAO;
import com.myapp.model.Person;
import com.myapp.model.Phone;
import com.myapp.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ilya Ten
 * Date: 2/17/2015
 */
@Service
public class PhoneServiceImpl implements PhoneService {
    private IPhoneDAO phoneDAO;

    @Autowired
    public PhoneServiceImpl(IPhoneDAO phoneDAO) { this.phoneDAO = phoneDAO; }

    @Override
    public Phone newPhone(Person person) {
        return new Phone(person);
    }
}
