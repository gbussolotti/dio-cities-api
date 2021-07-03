package com.gustavobussolotti.cities.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Distance {

    public static final String UNIT_MILES = "MILES";
    public static final String UNIT_METERS = "METERS";

    private BigDecimal value;
    private String unit;
}
