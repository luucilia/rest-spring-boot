package com.example.restspringboot.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.restspringboot.exceptions.UnsupportedMathOperationException;
import com.example.restspringboot.model.Person;
import com.example.restspringboot.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;
    //Autowired faz isso em tempo de execucao: private PersonServices service = new PersonServices();
    //Precisa colocar o @Service na classe PersonServices

    @RequestMapping(method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return service.findAll();
    } 

    @RequestMapping(value = "/{id}",
        method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(
        @PathVariable(value = "id") String id) {
        return service.findById(id);
    }  

    @RequestMapping(method=RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @RequestMapping(method=RequestMethod.PUT,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @RequestMapping(value = "/{id}",
        method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") String id) {
        service.delete(id);
    } 
}
