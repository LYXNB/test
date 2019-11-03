package com.aaa.controller;

import com.aaa.entity.Person;
import com.aaa.mapper.sys;
import com.aaa.service.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    @RequestMapping("selPerson")
    @ResponseBody
    public Object person(Person person,Integer page,Integer limit,String cname){
        PageHelper.startPage(page, limit);
        System.out.println(cname);
        List<Person> people = personService.selPerson(person);
        PageInfo pageInfo = new PageInfo(people);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        return tableData;
    }
    @RequestMapping("index")
    public Object index(){
        return "index";
    }

    @RequestMapping("addperson")
    @ResponseBody
    public Object insert(Person person){
        int add = personService.add(person);
        if(add==1){
            return "添加成功";
        }else{
            return "添加失败";
        }

    }
    @RequestMapping("del")
    @ResponseBody
    public Object del(Integer id){
        int add = personService.del(id);
        if(add==1){
            return sys.succ;
        }else{
            return "杀出失败";
        }

    }
    /*@RequestMapping("update")
    @ResponseBody
    public Object update(Person person){
        int add = personService.update(person);
        if(add==1){
            return sys.succ;
        }else{
            return "修改失败";
        }

    }*/
}
