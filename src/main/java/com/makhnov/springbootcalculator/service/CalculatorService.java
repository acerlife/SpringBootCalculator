package com.makhnov.springbootcalculator.service;

import com.makhnov.springbootcalculator.dao.CalculatorDao;
import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.SelectJoinStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CalculatorService {
    private final CalculatorDao calculatorDao;

    @Autowired
    public CalculatorService(CalculatorDao calculatorDao){
        this.calculatorDao = calculatorDao;
    }

    public void saveResult(String postfix_expression) throws Exception {
        calculatorDao.saveResult(postfix_expression);
    }
}
