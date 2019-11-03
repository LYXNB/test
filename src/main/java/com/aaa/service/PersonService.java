package com.aaa.service;

import com.aaa.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> selPerson(Person person);
    int add(Person person);
    int update(Person person);
    int del(Integer id);
}
