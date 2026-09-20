package com.daya.weekendsoffbackend.service;

import com.daya.weekendsoffbackend.common.PageResult;
import com.daya.weekendsoffbackend.entity.Company;
import com.daya.weekendsoffbackend.dto.CompanyQueryDTO;

public interface CompanyService {
    PageResult<Company> getCompanyList(CompanyQueryDTO query);
    Company getCompanyById(Long id);
    Company addCompany(Company company);
    Company updateCompany(Company company);
    int deleteCompany(Long id);
}