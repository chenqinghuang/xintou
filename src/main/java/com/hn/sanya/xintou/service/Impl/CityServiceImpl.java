package com.hn.sanya.xintou.service.Impl;

import com.hn.sanya.xintou.dao.CityDao;
import com.hn.sanya.xintou.entity.City;
import com.hn.sanya.xintou.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public List<City> findAllCity(){
        return cityDao.findAllCity();
    }

    public City findById(Long id) {
        return cityDao.findById(id);
    }

@Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    public Long updataCity(City city) {
        return cityDao.updataCity(city);
    }

    @Override
    public Long deleteCity(Long id) {
        return cityDao.deleteCity(id);
    }

}
