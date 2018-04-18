package com.hn.sanya.xintou.entity;

import java.io.Serializable;

/**
　　* @Description: 用户实体类
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/16 14:47
　　*/
public class User implements Serializable{


    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
