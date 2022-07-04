package com.qf.service;

import com.qf.pojo.Person;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.service
 * @Description:
 * @Date 2022/6/28 21:33
 */

public interface PersonService {

    void addPerson(Person person);

    Person findById(Long id);
}
