package com.daya.weekendsoffbackend.controller;

import com.daya.weekendsoffbackend.common.Result;
import com.daya.weekendsoffbackend.dto.LoginResponseDTO;
import com.daya.weekendsoffbackend.dto.UserLoginDTO;
import com.daya.weekendsoffbackend.dto.UserRegisterDTO;
import com.daya.weekendsoffbackend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "用户", description = "用户注册等")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "用户注册", description = "用户名不可重复；成功返回新用户 ID")
    @PostMapping("/register")
    public Result<Long> register(
            @Parameter(description = "注册信息") @Valid @RequestBody UserRegisterDTO dto) {
        Long userId = userService.register(dto);
        return Result.success(userId);
    }

    @Operation(summary = "上传头像", description = "上传头像文件，成功后返回头像访问路径")
    @PostMapping("/avatar")
    public Result<String> uploadAvatar(
            @Parameter(description = "用户 ID") @RequestParam("userId") Long userId,
            @Parameter(description = "头像文件") @RequestParam("file") MultipartFile file) {
        String avatarUrl = userService.uploadAvatar(userId, file);
        return Result.success(avatarUrl);
    }

    @Operation(summary = "更新用户头像", description = "需在 Header 添加 Authorization: Bearer 登录返回的 token")
    @PostMapping("/update-avatar")
    public Result<Void> updateAvatar(
            @Parameter(description = "用户 ID") @RequestParam("userId") Long userId,
            @Parameter(description = "头像 URL") @RequestParam("avatarUrl") String avatarUrl) {
        userService.updateAvatar(userId, avatarUrl);
        return Result.success(null);
    }

    @PostMapping("/login")
    public Result<LoginResponseDTO> login(
            @Parameter(description = "登录信息") @Valid @RequestBody UserLoginDTO dto) {
        LoginResponseDTO response = userService.login(dto);
        return Result.success(response);
    }
}
