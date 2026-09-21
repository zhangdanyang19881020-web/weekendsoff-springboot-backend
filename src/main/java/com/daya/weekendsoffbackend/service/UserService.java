package com.daya.weekendsoffbackend.service;

import org.springframework.stereotype.Service;
import com.daya.weekendsoffbackend.mapper.UserMapper;
import com.daya.weekendsoffbackend.dto.UserRegisterDTO;
import com.daya.weekendsoffbackend.entity.User;
import com.daya.weekendsoffbackend.exception.BusinessException;
import com.daya.weekendsoffbackend.dto.LoginResponseDTO;
import com.daya.weekendsoffbackend.dto.UserLoginDTO;
import com.daya.weekendsoffbackend.util.JwtUtil;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

    public UserService(UserMapper userMapper, JwtUtil jwtUtil) {
        this.userMapper = userMapper;
        this.jwtUtil = jwtUtil;
    }

    public Long register(UserRegisterDTO dto) {

        User existUser = userMapper.getUserByUsername(dto.getUsername());

        if (existUser != null) {
            throw new BusinessException(400, "用户名已存在");
        }

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setNickname(dto.getNickname());

        userMapper.insertUser(user);

        return user.getId();
    }

    public void updateAvatar(Long userId, String avatarUrl) {
        userMapper.updateUserAvatar(userId, avatarUrl);
    }

    public LoginResponseDTO login(UserLoginDTO dto) {
        User user = userMapper.getUserByUsername(dto.getUsername());
        if (user == null) {
            throw new BusinessException(400, "用户名不存在");
        }
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new BusinessException(400, "密码错误");
        }
        String token = jwtUtil.generateToken(user.getId(), user.getUsername());
        return new LoginResponseDTO(user.getId(), user.getUsername(), user.getAvatarUrl(), token);
    }

}