package com.makhnov.springbootcalculator.service.impl;

import com.makhnov.springbootcalculator.dao.impl.JobDaoImpl;
import com.makhnov.springbootcalculator.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService{
    private final JobDaoImpl jobDaoImpl;

    @Override
    public void saveResult(){
        jobDaoImpl.saveCalculatedExpressions();
    }
}
