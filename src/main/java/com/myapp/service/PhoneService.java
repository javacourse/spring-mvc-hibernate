package com.myapp.service;

import com.myapp.model.Person;
import com.myapp.model.Phone;

/**
 * Created by Ilya Ten
 * Date: 2/16/2015
 */
public interface PhoneService {
    public Phone newPhone(Person person);
}
