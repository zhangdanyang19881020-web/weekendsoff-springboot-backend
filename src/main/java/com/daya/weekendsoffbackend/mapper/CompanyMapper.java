package com.daya.weekendsoffbackend.mapper;

import com.daya.weekendsoffbackend.entity.Company;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface CompanyMapper {
        @Select("""
                        SELECT
                           id,
                           name,
                           weekends_off,
                           city
                        FROM company
                        LIMIT #{offset}, #{pageSize}
                        """)
        List<Company> getCompanyList(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);



        @Select("""
                        SELECT COUNT(*) FROM company
                           """)
        Long countCompanies();



        @Select("""
                        SELECT id, name, weekends_off, city FROM company WHERE id = #{id}
                        """)
        Company getCompanyById(Long id);



        @Insert("""
                            INSERT INTO company(
                            name,
                            weekends_off,
                            city
                        )
                            VALUES(
                                #{name},
                                #{weekendsOff},
                                #{city}
                            )
                        """)
        @Options(useGeneratedKeys = true, keyProperty = "id")
        int addCompany(Company company);



        @Update("""
                        UPDATE company
                        SET
                         name=#{name},
                         weekends_off=#{weekendsOff},
                         city=#{city}
                         WHERE id=#{id}
                        """)
        int updateCompany(Company company);

        

        @Delete("""
                        DELETE FROM company WHERE id = #{id}
                        """)
        int deleteCompany(Long id);
}
