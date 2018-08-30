package com.makhnov.springbootcalculator.service;

import com.makhnov.springbootcalculator.model.CalculatorResult;

public interface CalculatorService {
    CalculatorResult saveResult(String postfixExpression);
}
