package com.daya.weekendsoffbackend.service;

import com.daya.weekendsoffbackend.dto.PageResult;
import com.daya.weekendsoffbackend.entity.Company;

public interface CompanyService {
    PageResult<Company> getCompanyList(Integer page, Integer pageSize,String city,Boolean weekendsOff,String keyword);
    Company getCompanyById(Long id);
    Company addCompany(Company company);
    Company updateCompany(Company company);
    int deleteCompany(Long id);
}