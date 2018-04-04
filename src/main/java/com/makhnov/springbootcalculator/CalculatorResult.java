package com.makhnov.springbootcalculator;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
