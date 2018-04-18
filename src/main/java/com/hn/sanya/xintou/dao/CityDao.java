package com.hn.sanya.xintou.dao;

import com.hn.sanya.xintou.entity.City;
import com.hn.sanya.xintou.mapper.CityMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cityDao")
public class CityDao {

    @Autowired
    private CityMapper cityMapper;

    /*
       * 获取城市信息列表
       *
       * */
    /*List<City> findAllCity();

    *//*根据城市ID，获取城市信息*//*
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updataCity(City city);
     //根据账户查询
    public User findUserInfo(String username){
        return userMapper.findUserInfo(username);
    }

    Long deleteCity(Long id);*/

    public List<City> findAllCity(){
        return cityMapper.findAllCity();
    }

    public City findById(Long id){
        return cityMapper.findById(id);
    }
    public Long saveCity(City city){
        return cityMapper.saveCity(city);
    }
    public Long updataCity(City city){
        return cityMapper.updataCity(city);
    }
    public Long deleteCity(Long id){
        return cityMapper.deleteCity(id);
    }


}
