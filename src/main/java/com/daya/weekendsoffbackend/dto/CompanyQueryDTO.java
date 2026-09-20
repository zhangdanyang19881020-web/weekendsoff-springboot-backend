package com.daya.weekendsoffbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "公司列表查询参数（Query）")
public class CompanyQueryDTO {

    @Schema(description = "页码，从 1 开始", example = "1", defaultValue = "1")
    private Integer page = 1;

    @Schema(description = "每页条数", example = "10", defaultValue = "10")
    private Integer pageSize = 10;

    @Schema(description = "城市（精确匹配）", example = "宁波")
    private String city;

    @Schema(description = "是否双休", example = "true")
    private Boolean weekendsOff;

    @Schema(description = "公司名称关键词（模糊匹配）", example = "科技")
    private String keyword;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
