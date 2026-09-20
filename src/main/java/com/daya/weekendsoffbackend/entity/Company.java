package com.daya.weekendsoffbackend.entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "公司信息")
public class Company {
    @Schema(description = "公司ID",example = "1")
    private Long id;

    @Schema(description = "公司名称",example = "公司1")
    @NotBlank(message = "公司名称不能为空")
    @Size(min = 2, max = 100, message = "公司名称长度必须在2到100个字符之间")
    private String name;

    @Schema(description = "是否双休",example = "true")
    @NotNull(message = "是否双休不能为空")
    private boolean weekendsOff;

    @Schema(description = "城市",example = "北京")
    @NotBlank(message = "城市不能为空")
    private String city;

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

    public boolean getWeekendsOff() {
        return weekendsOff;
    }

    public void setWeekendsOff(boolean weekendsOff) {
        this.weekendsOff = weekendsOff;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
