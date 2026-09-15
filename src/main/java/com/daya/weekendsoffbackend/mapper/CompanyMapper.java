package com.daya.weekendsoffbackend.mapper;

import com.daya.weekendsoffbackend.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper 
public interface CompanyMapper {
    @Select ("""
            SELECT id,name,weekends_off,city FROM company
            """)
    List<Company> getCompanyList();

    @Select("""
            SELECT id, name, weekends_off, city FROM company WHERE id = #{id}
            """)
    Company getCompanyById(Long id);
}
