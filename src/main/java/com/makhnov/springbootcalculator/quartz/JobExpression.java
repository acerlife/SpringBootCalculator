package com.makhnov.springbootcalculator.quartz;

import com.makhnov.springbootcalculator.service.impl.JobServiceImpl;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class JobExpression extends QuartzJobBean {

    @Autowired
    JobServiceImpl jobService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        jobService.saveResult();
    }
}