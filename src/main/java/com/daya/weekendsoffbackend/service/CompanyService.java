package com.daya.weekendsoffbackend.service;

import com.daya.weekendsoffbackend.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getCompanyList();
    Company getCompanyById(Long id);
    Company addCompany(Company company);
    Company updateCompany(Company company);
    int deleteCompany(Long id);
}