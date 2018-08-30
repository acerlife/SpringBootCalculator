package com.makhnov.springbootcalculator.dao;

import com.makhnov.springbootcalculator.model.CalculatorResult;

public interface CalculatorDao {
    CalculatorResult saveResult(String postfixExpression);
}
