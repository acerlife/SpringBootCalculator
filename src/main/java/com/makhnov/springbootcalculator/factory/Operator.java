package com.makhnov.springbootcalculator.factory;

import org.springframework.stereotype.Component;

@Component
public interface Operator {
    double calculate(double lastNumber, double beforeLastNumber);
    String getSymbol();
}
