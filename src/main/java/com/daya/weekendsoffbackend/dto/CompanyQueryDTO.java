package com.daya.weekendsoffbackend.dto;

public class CompanyQueryDTO {
    private Integer page=1;
    private Integer pageSize=10;
    private String city;
    private Boolean weekendsOff;
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
