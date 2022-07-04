package com.qf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qf.pojo.Person;
import com.qf.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version V1.0
 * @Project springcloudtrymerging
 * @Package com.qf.controller
 * @Description:
 * @Date 2022/6/28 21:32
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person){
        personService.addPerson(person);
        return "success";
    }
    @GetMapping("/person/{id}")
    @HystrixCommand(fallbackMethod = "findByIdHystrix")
    public Person findById(@PathVariable Long id){
        return personService.findById(id);
    }
    public Person findByIdHystrix(@PathVariable Long id){
        Person person = new Person();
        person.setId(id);
        person.setName("OrderClient服务器错误，出现错误，降级");
        return person;
    }

}
