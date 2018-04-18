package com.hn.sanya.xintou.dao;

import com.hn.sanya.xintou.entity.User;
import com.hn.sanya.xintou.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

    /**
　　* @Description: 用户表
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/16 14:51
　　*/
@Repository("userDao")
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    //根据账户查询
    public User findUserInfo(String username){
        return userMapper.findUserInfo(username);
    }
}
