package com.daya.weekendsoffbackend.service;

import com.daya.weekendsoffbackend.entity.Company;
import com.daya.weekendsoffbackend.exception.BusinessException;
import com.daya.weekendsoffbackend.mapper.CompanyMapper;

import java.util.List;

/**
 * 重构前 {@code CompanyService} 的备份，仅供对照阅读。
 * <p>
 * 不要加 {@code @Service}，也不要改成 public 的 CompanyService，否则会与
 * {@link CompanyService} 接口、{@link com.daya.weekendsoffbackend.service.impl.CompanyServiceImpl} 冲突。
 */
class CompanyServiceBeforeRefactor {

    private final CompanyMapper companyMapper;

    CompanyServiceBeforeRefactor(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    public List<Company> getCompanyList() {
        // 备份代码：Mapper 已改为分页，此处仅示意
        // return companyMapper.getCompanyList(0, 100,"","",null);
        return null;
    }

    public Company getCompanyById(Long id) {
        Company company = companyMapper.getCompanyById(id);
        if (company == null) {
            throw new BusinessException(404, "公司不存在");
        }
        return company;
    }

    public Company addCompany(Company company) {
        companyMapper.addCompany(company);
        return company;
    }

    public Company updateCompany(Company company) {
        companyMapper.updateCompany(company);
        return company;
    }

    public int deleteCompany(Long id) {
        return companyMapper.deleteCompany(id);
    }
}
