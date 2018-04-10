package com.makhnov.springbootcalculator.controller;

import com.makhnov.springbootcalculator.CalculatorExpression;
import com.makhnov.springbootcalculator.CalculatorResult;
import com.makhnov.springbootcalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    };

    @PostMapping
    public CalculatorResult saveResult(@RequestBody CalculatorExpression calculatorExpression) throws Exception{
       return calculatorService.saveResult(calculatorExpression.getPostfixExpression());
    }
}
