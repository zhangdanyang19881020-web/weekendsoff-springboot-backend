package com.daya.weekendsoffbackend.controller;

import com.daya.weekendsoffbackend.entity.Company;
import com.daya.weekendsoffbackend.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

import com.daya.weekendsoffbackend.common.Result;
import com.daya.weekendsoffbackend.dto.CompanyAddDTO;
import com.daya.weekendsoffbackend.dto.CompanyResponseDTO;
import com.daya.weekendsoffbackend.dto.CompanyUpdateDTO;
import com.daya.weekendsoffbackend.dto.PageResult;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
public class HelloController {

    private final CompanyService companyService;

    public HelloController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("api/company")
    public Map<String, Object> getCompany() {
        Map<String, Object> company = new HashMap<>();
        company.put("id", 1);
        company.put("name", "宁波测试科技有限公司");
        company.put("weekendsOff", true);
        company.put("city", "宁波");
        return company;
    }

    @GetMapping("api/company/{id}")
    public Result<CompanyResponseDTO> getCompanyById(@PathVariable Long id) {
        // 1.直接返回Map
        // Map<String,Object> company =new HashMap<>();
        // company.put("id",id);
        // company.put("name","公司"+id+"号");
        // company.put("weekendsOff",true);
        // company.put("city","宁波");
        // return company;

        // 2.直接返回Company对象
        // Company company =new Company();
        // company.setId(id);
        // company.setName("宁波测试科技有限公司"+id+"号");
        // company.setWeekendsOff(true);
        // company.setCity("宁波");
        // return company;

        // 3.DTO
        Company company = companyService.getCompanyById(id);
        CompanyResponseDTO dto = new CompanyResponseDTO();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setWeekendsOff(company.getWeekendsOff());
        dto.setCity(company.getCity());
        return Result.success(dto);

        // 3.调用Service层
        // return Result.success(companyService.getCompanyById(id));

    }

    @GetMapping("/api/companies")
    public Result<PageResult<Company>> getCompanyList(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        PageResult<Company> pageResult = companyService.getCompanyList(page, pageSize);
        return Result.success(pageResult);
    }

    @PostMapping("/api/companies/addCompany")
    public Result<Company> addCompany(@Valid @RequestBody CompanyAddDTO dto) {
        Company company = new Company();
        company.setName(dto.getName());
        company.setCity(dto.getCity());
        company.setWeekendsOff(Boolean.TRUE.equals(dto.getWeekendsOff()));
        return Result.success(companyService.addCompany(company));
    }

    @PutMapping("/api/companies/{id}")
    public Result<Void> updateCompany(
            @PathVariable Long id,
            @Valid @RequestBody CompanyUpdateDTO dto) {
        Company company = new Company();
        company.setId(id);
        company.setName(dto.getName());
        company.setCity(dto.getCity());
        company.setWeekendsOff(Boolean.TRUE.equals(dto.getWeekendsOff()));
        companyService.updateCompany(company);
        return Result.success(null);
    }

    @DeleteMapping("/api/companies/{id}")
    public Result<Integer> deleteCompany(@PathVariable Long id) {
        return Result.success(companyService.deleteCompany(id));
    }
}
