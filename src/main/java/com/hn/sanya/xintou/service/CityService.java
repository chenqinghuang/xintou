package com.hn.sanya.xintou.service;

import com.hn.sanya.xintou.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityService {

    /*
       * 获取城市信息列表
       *
       * */
     List<City> findAllCity();

    /*根据城市ID，获取城市信息*/
     City findById(Long id);

     Long saveCity(City city);

    Long updataCity(City city);

     Long deleteCity(Long id);
}
