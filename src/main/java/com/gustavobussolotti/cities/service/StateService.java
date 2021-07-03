package com.gustavobussolotti.cities.service;

import com.gustavobussolotti.cities.entity.State;
import com.gustavobussolotti.cities.exception.NotFoundException;
import com.gustavobussolotti.cities.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StateService {

    private final StateRepository stateRepository;
    //private final BeerMapper beerMapper = BeerMapper.INSTANCE;

    public Page<State> listAll(Pageable page) {
        return stateRepository.findAll(page);
        /*
        return countryRepository.findAll(page)
                .stream()
                //.map(beerMapper::toDTO)
                .collect(Collectors.toList());

         */
    }

    public List<State> listAll() {
        return stateRepository.findAll();
        /*
        return countryRepository.findAll(page)
                .stream()
                //.map(beerMapper::toDTO)
                .collect(Collectors.toList());

         */
    }

    public State findByName(String stateName) throws NotFoundException {
        State found = stateRepository.findByName(stateName)
                .orElseThrow(() -> new NotFoundException(
                        String.format("State with name %s not found in the system.", stateName)
                ));
        return found;
    }

    public State findByUf(String uf) throws NotFoundException {
        State found = stateRepository.findByUf(uf)
                .orElseThrow(() -> new NotFoundException(
                        String.format("State with uf %s not found in the system.", uf)
                ));
        return found;
    }
}
