package com.hn.sanya.xintou.controller;

import com.hn.sanya.xintou.entity.City;
import com.hn.sanya.xintou.mapper.CityMapper;
import com.hn.sanya.xintou.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "city")
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private CityMapper cityMapper;

    @RequestMapping(value = "findOneCity",method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id){
        return cityService.findById(id);
    }

    @RequestMapping(value = "findAllCity",method = RequestMethod.GET)
    public List<City> findAllCity(){
        return cityService.findAllCity();
    }
}
