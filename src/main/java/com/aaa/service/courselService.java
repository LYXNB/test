package com.aaa.service;

import com.aaa.entity.Major;
import com.aaa.entity.coursel;
import com.aaa.entity.coursetype;

import java.util.List;

public interface courselService {
    List<coursel> selCourse(coursel coursel);
    List<Major> selJson();
    List<coursetype> selCoutu();
    int update(coursel coursel);
    int addcou(coursel coursel);
    int delcou(Integer cid);
    int hfcou(Integer cid);
}
