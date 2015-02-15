package com.myapp.dao.impl;

import com.myapp.dao.api.ISkillDAO;
import com.myapp.model.Skill;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Odour on 15.02.2015.
 */
@Repository(value = "skillDao")
@Transactional(readOnly = true)
public class SkillDAOImpl extends AbstractHibernateDAO<Skill, Long> implements ISkillDAO{

}
