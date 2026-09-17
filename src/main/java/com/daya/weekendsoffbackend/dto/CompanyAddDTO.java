package com.daya.weekendsoffbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CompanyAddDTO {
    @NotBlank(message = "公司名称不能为空")
    @Size(max = 100, message = "公司名称不能超过100个字符")
    private String name;

    @NotBlank(message = "城市不能为空")
    private String city;

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
