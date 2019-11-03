package com.aaa.service.Impl;

import com.aaa.entity.Person;
import com.aaa.mapper.PersonMapper;
import com.aaa.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonMapper personMapper;
    @Override
    public List<Person> selPerson(Person person) {
        return personMapper.selPerson(person);
    }

    @Override
    public int add(Person person) {
        return personMapper.add(person);
    }

    @Override
    public int update(Person person) {
        return personMapper.update(person);
    }

    @Override
    public int del(Integer id) {
        return personMapper.del(id);
    }
}
