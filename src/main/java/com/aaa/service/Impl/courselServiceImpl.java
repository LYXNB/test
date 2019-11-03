package com.aaa.service.Impl;
import com.aaa.entity.Major;

import com.aaa.entity.coursel;
import com.aaa.entity.coursetype;
import com.aaa.mapper.courseMapperl;
import com.aaa.service.courselService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class courselServiceImpl implements courselService {
    @Resource
    private com.aaa.mapper.courseMapperl courseMapperl;
    @Override
    public List<coursel> selCourse(coursel coursel) {
        return courseMapperl.selCourse(coursel);
    }

    @Override
    public List<Major> selJson() {
        return courseMapperl.selJson();
    }

    @Override
    public List<coursetype> selCoutu() {
        return courseMapperl.selCoutu();
    }

    @Override
    public int update(coursel coursel) {
        return courseMapperl.update(coursel);
    }

    @Override
    public int addcou(coursel coursel) {
        return courseMapperl.addcou(coursel);
    }

    @Override
    public int delcou(Integer cid) {
        return courseMapperl.delcou(cid);
    }

    @Override
    public int hfcou(Integer cid) {
        return courseMapperl.hfcou(cid);
    }
}
