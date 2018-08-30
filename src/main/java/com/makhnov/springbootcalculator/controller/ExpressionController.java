package com.makhnov.springbootcalculator.controller;

import com.makhnov.springbootcalculator.model.JobExpression;
import com.makhnov.springbootcalculator.service.impl.ExpressionServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expressions")
public class ExpressionController {
    private final ExpressionServiceImpl jobService;

    public ExpressionController(ExpressionServiceImpl jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/")
    public long saveExpression(@RequestBody JobExpression jobExpression) throws Exception{
        return jobService.saveResult(jobExpression.getExpression());
    }
}
