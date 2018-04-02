package com.makhnov.springbootcalculator.service;

import com.makhnov.springbootcalculator.dao.CalculatorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    @Autowired
    private CalculatorDao calculatorDao;

    public void saveResult(String postfix_expression) throws Exception{
        calculatorDao.saveResult(postfix_expression);
    }
}
