package com.makhnov.springbootcalculator.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.makhnov.springbootcalculator.CalculatorResultDeserializer;

@JsonDeserialize(using = CalculatorResultDeserializer.class)
public class CalculatorResult {
    private final double result;

    public CalculatorResult(double result){
        this.result = result;
    }

    public double getResult() {
        return result;
    }
}
