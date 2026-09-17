package com.daya.weekendsoffbackend.service.impl;

import com.daya.weekendsoffbackend.entity.Company;
import com.daya.weekendsoffbackend.exception.BusinessException;
import com.daya.weekendsoffbackend.mapper.CompanyMapper;
import com.daya.weekendsoffbackend.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service  
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public List<Company> getCompanyList() {
        return companyMapper.getCompanyList();
    }

    @Override
    public Company getCompanyById(Long id) {
       Company company = companyMapper.getCompanyById(id);
       if (company == null) {
        throw new BusinessException(404, "公司不存在");
       }
       return company;
    }

    @Override
    public Company addCompany(Company company) {
        companyMapper.addCompany(company);
        return company;
    }

    @Override
    public Company updateCompany(Company company) {
        companyMapper.updateCompany(company);
        return company; 
    }

    @Override
    public int deleteCompany(Long id) {
        return companyMapper.deleteCompany(id);
    }
}
