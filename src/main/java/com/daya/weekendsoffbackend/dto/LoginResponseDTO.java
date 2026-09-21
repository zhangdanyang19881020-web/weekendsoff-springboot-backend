package com.daya.weekendsoffbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "登录成功响应")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {

    @Schema(description = "用户 ID", example = "1")
    private Long id;

    @Schema(description = "用户名", example = "zhangdaya")
    private String username;

    @Schema(description = "头像 URL", example = "https://example.com/avatar.png")
    private String avatar;

    @Schema(description = "登录令牌（后续鉴权用）")
    private String token;
}
