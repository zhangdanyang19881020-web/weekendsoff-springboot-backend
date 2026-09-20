package com.daya.weekendsoffbackend.mapper;

import org.apache.ibatis.annotations.Insert;    
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import com.daya.weekendsoffbackend.entity.User;

@Mapper
public interface UserMapper {

    @Select("""
            SELECT * FROM user WHERE username = #{username}
            """)
    User getUserByUsername(String username);


    @Insert("""
            INSERT INTO user (username, password, nickname) VALUES (#{username}, #{password}, #{nickname})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

}