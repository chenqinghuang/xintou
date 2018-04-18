package com.hn.sanya.xintou.mapper;

import com.hn.sanya.xintou.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
　　* @Description: 用户表映射
　  * @author syiti
    * @Method
　　* @params
　　* @return
　　* @date 2018/3/16 14:52
　　*/
@Mapper
public interface UserMapper {

    //根据账户查询
    public User findUserInfo(String username);
}
