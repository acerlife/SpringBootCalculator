package com.makhnov.springbootcalculator.service;

import com.makhnov.springbootcalculator.dao.CalculatorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalculatorService {
    private final CalculatorDao calculatorDao;

    @Autowired
    public CalculatorService(CalculatorDao calculatorDao){
        this.calculatorDao = calculatorDao;
    }

    @Transactional
    public String saveResult(String postfix_expression) throws Exception {
       return calculatorDao.saveResult(postfix_expression);
    }
}
