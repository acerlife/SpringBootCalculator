package com.makhnov.springbootcalculator.factory;

import org.springframework.stereotype.Component;

@Component
public class MinusOperator implements Operator{

    @Override
    public double calculate(double lastNumber, double beforeLastNumber) {
        return lastNumber-beforeLastNumber;
    }

    @Override
    public String getSymbol() {
        return "-";
    }
}
