package com.makhnov.springbootcalculator.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonDeserialize(using = CalculatorResultDeserializer.class)
@Getter
@AllArgsConstructor
public class CalculatorResult {
    private final double result;

}
