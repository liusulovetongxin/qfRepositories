package com.qf.service.impl;

import com.qf.mapper.PersonMapper;
import com.qf.openfeign.OrderOpenFeign;
import com.qf.pojo.Person;
import com.qf.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.service.impl
 * @Description:
 * @Date 2022/6/28 21:36
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private PersonMapper personMapper;

    @Autowired
    public void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    private OrderOpenFeign orderOpenFeign;

    @Autowired
    public void setOrderOpenFeign(OrderOpenFeign orderOpenFeign) {
        this.orderOpenFeign = orderOpenFeign;
    }

    @Override
    public void addPerson(Person person) {
        personMapper.addPerson(person);
    }

    @Override
    public Person findById(Long id) {
        Person person =personMapper.findById(id);
        person.setOrders(orderOpenFeign.findByPid(id));
        System.err.println(person);
        return person;
    }
}
