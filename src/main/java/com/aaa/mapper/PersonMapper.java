package com.aaa.mapper;

import com.aaa.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PersonMapper {
    List<Person> selPerson(Person person);
    int add(Person person);
    int update(Person person);
    int del(Integer id);
}
