package com.personal.cloud.demo.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.personal.cloud.demo.util.MySerializerUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019-07-30.
 */
public class DemoEntityDto implements Serializable {

    private String name;

    private String code;

    private Integer num;

    private String description;

    private String type;

    private Date operateDate;

    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JsonSerialize(using = MySerializerUtils.class)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
