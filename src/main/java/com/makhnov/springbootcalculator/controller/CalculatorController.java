package com.makhnov.springbootcalculator.controller;

import com.makhnov.springbootcalculator.model.CalculatorExpression;
import com.makhnov.springbootcalculator.model.CalculatorResult;
import com.makhnov.springbootcalculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculatorController {
    private final CalculatorService calculatorService;
    
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    };

    @PostMapping
    public CalculatorResult saveResult(@RequestBody CalculatorExpression calculatorExpression) throws Exception{
       return calculatorService.saveResult(calculatorExpression.getPostfixExpression());
    }
}
