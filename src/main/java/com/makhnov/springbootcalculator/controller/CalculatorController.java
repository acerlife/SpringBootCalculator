package com.makhnov.springbootcalculator.controller;

import com.makhnov.springbootcalculator.dao.CalculatorDao;
import com.makhnov.springbootcalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculatorController {
    @Autowired
   private CalculatorService calculatorService;

    @GetMapping("/{postfix_expression}")
    public @ResponseBody void saveResult(@PathVariable String postfix_expression) throws Exception{
        calculatorService.saveResult(postfix_expression);
    }
}
