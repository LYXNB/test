package com.aaa.mapper;

import com.aaa.entity.Major;
import com.aaa.entity.coursel;
import com.aaa.entity.coursetype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface courseMapperl {
    List<coursel> selCourse(coursel coursel);
    List<Major> selJson();
    List<coursetype> selCoutu();
    int update(coursel coursel);
    int addcou(coursel coursel);
    int delcou(Integer cid);
    int hfcou(Integer cid);
}
