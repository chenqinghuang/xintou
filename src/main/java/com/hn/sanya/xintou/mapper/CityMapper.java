package com.hn.sanya.xintou.mapper;

import com.hn.sanya.xintou.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CityMapper {

    /*
       * 获取城市信息列表
       *
       * */
   public List<City> findAllCity();

    /*根据城市ID，获取城市信息*/

    public City findById(@Param("id") Long id);

    public Long saveCity(City city);

    public Long updataCity(City city);

    public Long deleteCity(Long id);
}
