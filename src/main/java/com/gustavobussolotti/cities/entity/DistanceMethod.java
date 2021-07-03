package com.gustavobussolotti.cities.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DistanceMethod{
    NATIVE("native"), CUBE("cube");

    private String method;

    @Override
    public String toString(){
        return this.method;
    }

}