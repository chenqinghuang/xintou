package com.hn.sanya.xintou.entity;

import java.io.Serializable;

public class City implements Serializable{

    /*
    * 城市编号
    * */
    private Long id;


    /*省份编号*/
    private Long proviceId;

    /*城市名称*/
    private String cityName;

    /*描述*/
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProviceId() {
        return proviceId;
    }

    public void setProviceId(Long proviceId) {
        this.proviceId = proviceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
