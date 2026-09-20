package com.daya.weekendsoffbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "新增公司请求体")
public class CompanyAddDTO {

    @Schema(description = "公司名称", example = "张大牙科技有限公司", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "公司名称不能为空")
    @Size(max = 100, message = "公司名称不能超过100个字符")
    private String name;

    @Schema(description = "所在城市", example = "舟山", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "城市不能为空")
    private String city;

    @Schema(description = "是否双休", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否双休不能为空")
    private Boolean weekendsOff;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getWeekendsOff() {
        return weekendsOff;
    }

    public void setWeekendsOff(Boolean weekendsOff) {
        this.weekendsOff = weekendsOff;
    }
}
