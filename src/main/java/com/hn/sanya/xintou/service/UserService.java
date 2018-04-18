package com.hn.sanya.xintou.service;

import com.hn.sanya.xintou.entity.User;

/**
　　* @Description: 用户表业务层接口
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/16 15:03
　　*/
public interface UserService {

    //根据账户查询
    public User getFindUserInfo(String username);
}
