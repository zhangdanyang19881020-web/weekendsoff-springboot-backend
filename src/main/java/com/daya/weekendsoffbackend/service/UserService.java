package com.daya.weekendsoffbackend.service;

import com.daya.weekendsoffbackend.dto.LoginResponseDTO;
import com.daya.weekendsoffbackend.dto.UserLoginDTO;
import com.daya.weekendsoffbackend.dto.UserRegisterDTO;
import com.daya.weekendsoffbackend.entity.User;
import com.daya.weekendsoffbackend.exception.BusinessException;
import com.daya.weekendsoffbackend.mapper.UserMapper;
import com.daya.weekendsoffbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;
    private final Path uploadDir;

    public UserService(
            UserMapper userMapper,
            JwtUtil jwtUtil,
            @Value("${app.upload-dir:uploads}") String uploadDir) {
        this.userMapper = userMapper;
        this.jwtUtil = jwtUtil;
        this.uploadDir = Path.of(uploadDir);
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

    public String uploadAvatar(Long userId, MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new BusinessException(400, "头像文件不能为空");
        }
        try {
            Files.createDirectories(uploadDir);
            String ext = "";
            String original = file.getOriginalFilename();
            if (original != null && original.contains(".")) {
                ext = original.substring(original.lastIndexOf('.'));
            }
            String filename = userId + "-" + UUID.randomUUID() + ext;
            Path target = uploadDir.resolve(filename);
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            String avatarUrl = "/uploads/" + filename;
            userMapper.updateUserAvatar(userId, avatarUrl);
            return avatarUrl;
        } catch (IOException e) {
            throw new BusinessException(500, "头像上传失败");
        }
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
