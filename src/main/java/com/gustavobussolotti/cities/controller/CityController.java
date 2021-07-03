package com.gustavobussolotti.cities.controller;

import com.gustavobussolotti.cities.entity.City;
import com.gustavobussolotti.cities.exception.NotFoundException;
import com.gustavobussolotti.cities.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CityController {

    private final CityService cityService;

    @GetMapping
    public Page<City> listAll(Pageable page){
        return cityService.listAll(page);
    }


    @GetMapping("/{uf}")
    public Page<City> listAllByState(@PathVariable String uf, Pageable page) throws NotFoundException {
        return cityService.listAllByState(uf, page);
    }
}
