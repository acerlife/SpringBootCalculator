package com.makhnov.springbootcalculator.service.impl;

import com.makhnov.springbootcalculator.dao.impl.CalculatorDaoImpl;
import com.makhnov.springbootcalculator.model.CalculatorResult;
import com.makhnov.springbootcalculator.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService{
    private final CalculatorDaoImpl calculatorDaoImpl;

    @Override
    public CalculatorResult saveResult(String postfixExpression){
       return calculatorDaoImpl.saveResult(postfixExpression);
    }
}
