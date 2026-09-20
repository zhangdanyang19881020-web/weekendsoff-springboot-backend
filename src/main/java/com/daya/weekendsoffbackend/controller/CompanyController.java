package com.daya.weekendsoffbackend.controller;

import com.daya.weekendsoffbackend.common.PageResult;
import com.daya.weekendsoffbackend.common.Result;
import com.daya.weekendsoffbackend.dto.CompanyAddDTO;
import com.daya.weekendsoffbackend.dto.CompanyQueryDTO;
import com.daya.weekendsoffbackend.dto.CompanyResponseDTO;
import com.daya.weekendsoffbackend.dto.CompanyUpdateDTO;
import com.daya.weekendsoffbackend.entity.Company;
import com.daya.weekendsoffbackend.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "公司", description = "公司查询与 CRUD")
@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Operation(summary = "示例公司（演示）", description = "返回硬编码 Map，仅用于学习演示")
    @GetMapping("api/company")
    public Map<String, Object> getCompany() {
        Map<String, Object> company = new HashMap<>();
        company.put("id", 1);
        company.put("name", "宁波测试科技有限公司");
        company.put("weekendsOff", true);
        company.put("city", "宁波");
        return company;
    }

    @Operation(summary = "按 ID 查询公司")
    @GetMapping("api/company/{id}")
    public Result<CompanyResponseDTO> getCompanyById(
            @Parameter(description = "公司 ID", example = "1", required = true)
            @PathVariable Long id) {
        Company company = companyService.getCompanyById(id);
        CompanyResponseDTO dto = new CompanyResponseDTO();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setWeekendsOff(company.getWeekendsOff());
        dto.setCity(company.getCity());
        return Result.success(dto);
    }

    @Operation(summary = "获取公司列表", description = "分页查询，支持按城市、是否双休、名称关键词筛选")
    @GetMapping("/api/companies")
    public Result<PageResult<Company>> getCompanyList(
            @Parameter(description = "查询条件（Query 参数）")
            @ModelAttribute CompanyQueryDTO query) {
        PageResult<Company> pageResult = companyService.getCompanyList(query);
        return Result.success(pageResult);
    }

    @Operation(summary = "新增公司")
    @PostMapping("/api/companies/addCompany")
    public Result<Company> addCompany(
            @Parameter(description = "新增公司信息")
            @Valid @RequestBody CompanyAddDTO dto) {
        Company company = new Company();
        company.setName(dto.getName());
        company.setCity(dto.getCity());
        company.setWeekendsOff(Boolean.TRUE.equals(dto.getWeekendsOff()));
        return Result.success(companyService.addCompany(company));
    }

    @Operation(summary = "更新公司", description = "公司 ID 放在路径上，body 中不需要 id")
    @PutMapping("/api/companies/{id}")
    public Result<Void> updateCompany(
            @Parameter(description = "公司 ID", example = "6", required = true)
            @PathVariable Long id,
            @Parameter(description = "要更新的公司信息")
            @Valid @RequestBody CompanyUpdateDTO dto) {
        Company company = new Company();
        company.setId(id);
        company.setName(dto.getName());
        company.setCity(dto.getCity());
        company.setWeekendsOff(Boolean.TRUE.equals(dto.getWeekendsOff()));
        companyService.updateCompany(company);
        return Result.success(null);
    }

    @Operation(summary = "删除公司")
    @DeleteMapping("/api/companies/{id}")
    public Result<Integer> deleteCompany(
            @Parameter(description = "公司 ID", example = "6", required = true)
            @PathVariable Long id) {
        return Result.success(companyService.deleteCompany(id));
    }
}
