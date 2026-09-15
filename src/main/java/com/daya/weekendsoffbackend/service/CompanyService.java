package com.daya.weekendsoffbackend.service;

import com.daya.weekendsoffbackend.entity.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    public Company getCompanyById(Long id){
        Company company =new Company();
        company.setId(id);
        company.setName("宁波测试科技有限公司--"+id+"号");
        company.setWeekendsOff(true);
        company.setCity("宁波");

        return company;
    }
}
