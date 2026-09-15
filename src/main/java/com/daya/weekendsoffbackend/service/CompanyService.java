package com.daya.weekendsoffbackend.service;

import com.daya.weekendsoffbackend.entity.Company;
import com.daya.weekendsoffbackend.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service
// public class CompanyService {
//     public Company getCompanyById(Long id){
//         Company company =new Company();
//         company.setId(id);
//         company.setName("宁波测试科技有限公司--"+id+"号");
//         company.setWeekendsOff(true);
//         company.setCity("宁波");

//         return company;
//     }

//     public List<Company> getCompanyList(){
//         List<Company> companies = new ArrayList<>();

//         Company company1 = new Company();
//         company1.setId(1L);
//         company1.setName("宁波A测试科技有限公司");
//         company1.setWeekendsOff(true);
//         company1.setCity("宁波");
//         companies.add(company1);

//         Company company2 = new Company();
//         company2.setId(2L);
//         company2.setName("宁波B测试科技有限公司");
//         company2.setWeekendsOff(true);
//         company2.setCity("宁波");
//         companies.add(company2);

//         return companies;
//     }

// }

@Service 
public class CompanyService {
    
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    public List<Company> getCompanyList() {
        return companyMapper.getCompanyList();
    }

    public Company getCompanyById(Long id) {
        return companyMapper.getCompanyById(id);
    }

    public Company addCompany(Company company){
        companyMapper.addCompany(company);
        return company;
    }
}