package com.aaa.controller;

import com.aaa.entity.Major;
import com.aaa.entity.coursel;
import com.aaa.entity.coursetype;
import com.aaa.mapper.sys;
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
public class courseController {
    @Autowired
    private com.aaa.service.courselService courselService;

    @RequestMapping("selCou")
    public String selCourse(){
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        return "selCou";
    }
    @RequestMapping("sel")
    @ResponseBody
   public Object sel(Integer page, Integer limit,coursel coursel,String cname){

        coursel.setCname(cname);
        PageHelper.startPage(page, limit);
        List<coursel> cs = courselService.selCourse(coursel);



        PageInfo pageInfo = new PageInfo(cs);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        System.out.print(cs);
        return tableData;
    }



    @RequestMapping("selJson")
    @ResponseBody
    public Object selJson(){
        List<Major> major  =courselService.selJson();
        return major;
    }
    @RequestMapping("selCoutu")
    @ResponseBody
    public Object selCoutu(){
        List<coursetype> coursetype=courselService.selCoutu();
        return coursetype;
    }
    @RequestMapping("update")
    @ResponseBody
    public Object update(coursel coursel){
         int update = courselService.update(coursel);
        if(update==1){
            return sys.succ;
        }else{
            return "修改失败";
        }

    }
    @RequestMapping("addcou")
    @ResponseBody
    public Object addcou(coursel coursel){
        int addcou = courselService.addcou(coursel);
        if(addcou==1){
            return "添加成功";
        }else{
            return "添加失败";
        }

    }
    @RequestMapping("delcou")
    @ResponseBody
    public Object delcou(Integer cid){
        int add = courselService.delcou(cid);
        if(add==1){
            return sys.succ;
        }else{
            return "删除失败";
        }

    }

    @RequestMapping("hfcou")
    @ResponseBody
    public Object hfcou(Integer cid){
        int add = courselService.hfcou(cid);
        if(add==1){
            return sys.succ;
        }else{
            return "恢复失败";
        }

    }
}
