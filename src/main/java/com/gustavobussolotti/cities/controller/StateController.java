package com.gustavobussolotti.cities.controller;


import com.gustavobussolotti.cities.entity.State;
import com.gustavobussolotti.cities.exception.NotFoundException;
import com.gustavobussolotti.cities.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StateController {

    private final StateService stateService;

    @GetMapping
    public List<State> listAll(){
        return stateService.listAll();
    }


    @GetMapping("/{uf}")
    public State findByName(@PathVariable String uf) throws NotFoundException {
        return stateService.findByUf(uf);
    }
}
