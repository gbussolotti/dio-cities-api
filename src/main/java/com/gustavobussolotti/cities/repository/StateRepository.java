package com.gustavobussolotti.cities.repository;

import com.gustavobussolotti.cities.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository  extends JpaRepository<State, Long> {
    Optional<State> findByName(String nome);
    Optional<State> findByUf(String uf);
}
