package com.daya.weekendsoffbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "公司信息（响应）")
public class CompanyResponseDTO {

    @Schema(description = "公司 ID", example = "1")
    private Long id;

    @Schema(description = "公司名称", example = "宁波测试科技有限公司")
    private String name;

    @Schema(description = "所在城市", example = "宁波")
    private String city;

    @Schema(description = "是否双休", example = "true")
    private Boolean weekendsOff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
