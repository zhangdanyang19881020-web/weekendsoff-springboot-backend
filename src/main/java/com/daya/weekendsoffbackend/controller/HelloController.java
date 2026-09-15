package com.daya.weekendsoffbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("api/company")
    public Map<String,Object> getCompany(){
        Map<String,Object> company =new HashMap<>();
        company.put("id",1);
        company.put("name","宁波测试科技有限公司");
        company.put("weekendsOff",true);
        company.put("city","宁波");
        return company;
    }

    @GetMapping("api/company/{id}")
    public Map<String,Object> getCompanyById(@PathVariable Long id){
        Map<String,Object> company =new HashMap<>();
        company.put("id",id);
        company.put("name","公司"+id+"号");
        company.put("weekendsOff",true);
        company.put("city","宁波");
        return company;
    }
}
