package com.gustavobussolotti.cities.service;

import com.gustavobussolotti.cities.entity.City;
import com.gustavobussolotti.cities.entity.State;
import com.gustavobussolotti.cities.exception.NotFoundException;
import com.gustavobussolotti.cities.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CityService {

    private final CityRepository cityRepository ;
    private final StateService stateService ;

    public Page<City> listAll(Pageable page) {
        return  cityRepository.findAll(page);
    }


    public Page<City> listAllByState(String uf, Pageable page) throws NotFoundException {
        State found = stateService.findByUf(uf);
        return cityRepository.findAllByUf(found, page);
    }
}
