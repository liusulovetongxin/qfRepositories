package com.qf.mapper;

import com.qf.pojo.Person;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.mapper
 * @Description:
 * @Date 2022/6/28 21:40
 */

public interface PersonMapper {

    void addPerson(Person person);

    Person findById(Long id);
}
