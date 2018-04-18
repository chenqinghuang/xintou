package com.hn.sanya.xintou.service.Impl;

import com.hn.sanya.xintou.dao.UserDao;
import com.hn.sanya.xintou.entity.User;
import com.hn.sanya.xintou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
　　* @Description: 用户表业务层实现
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/16 15:06
　　*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //根据账户名查询
    public User getFindUserInfo(String username) {
        return userDao.findUserInfo(username);
    }
}
