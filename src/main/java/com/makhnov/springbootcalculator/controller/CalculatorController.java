package com.makhnov.springbootcalculator.controller;

import com.makhnov.springbootcalculator.model.CalculatorExpression;
import com.makhnov.springbootcalculator.model.CalculatorResult;
import com.makhnov.springbootcalculator.service.impl.CalculatorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalculatorController {
    private final CalculatorServiceImpl calculatorServiceImpl;

    @PostMapping("/")
    public CalculatorResult saveResult(@RequestBody CalculatorExpression calculatorExpression) throws Exception {
        return calculatorServiceImpl.saveResult(calculatorExpression.getPostfixExpression());
    }
}
