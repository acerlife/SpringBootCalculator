package com.makhnov.springbootcalculator.controller;

import com.makhnov.springbootcalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    };

    @GetMapping("/{postfix_expression}")
    public @ResponseBody
    HttpStatus saveResult(@PathVariable String postfix_expression) throws Exception{
       calculatorService.saveResult(postfix_expression);
       return HttpStatus.OK;
    }
}
