package com.makhnov.springbootcalculator.service.impl;

import com.makhnov.springbootcalculator.dao.impl.ExpressionDaoImpl;
import com.makhnov.springbootcalculator.service.ExpressionService;
import org.springframework.stereotype.Service;

@Service
public class ExpressionServiceImpl implements ExpressionService{
    private final ExpressionDaoImpl jobDao;

    public ExpressionServiceImpl(ExpressionDaoImpl jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public long saveResult(String expression){
        return jobDao.saveResult(expression);
    }
}
