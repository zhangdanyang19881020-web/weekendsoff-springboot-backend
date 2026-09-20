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
                        <script>
                                SELECT
                                   id,
                                   name,
                                   weekends_off,
                                   city
                                FROM company

                              <where>
                                <if test="city != null and city != ''">
                                    AND city = #{city}
                                </if>
                                <if test="weekendsOff != null and weekendsOff != ''">
                                    AND weekends_off = #{weekendsOff}
                                </if>
                                <if test="keyword != null and keyword != ''">
                                    AND name LIKE CONCAT('%', #{keyword}, '%')
                                </if>
                                  </where>

                                ORDER BY id DESC

                                LIMIT #{offset}, #{pageSize}
                                </script>
                                """)
        List<Company> getCompanyList(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize,
                        @Param("city") String city, @Param("weekendsOff") Boolean weekendsOff,
                        @Param("keyword") String keyword);

        @Select("""
                        <script>
                                SELECT COUNT(*) FROM company
                                <where>
                                        <if test="city != null and city != ''">
                                        AND city = #{city}
                                        </if>
                                        <if test="weekendsOff != null and weekendsOff != ''">
                                        AND weekends_off = #{weekendsOff}
                                        </if>
                                        <if test="keyword != null and keyword != ''">
                                        AND name LIKE CONCAT('%', #{keyword}, '%')
                                        </if>
                                        </where>
                        </script>
                                   """)
        Long countCompanies(@Param("city") String city,
                        @Param("weekendsOff") Boolean weekendsOff,
                        @Param("keyword") String keyword);

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
