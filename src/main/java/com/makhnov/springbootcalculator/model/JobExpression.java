package com.makhnov.springbootcalculator.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

@JsonDeserialize(using = JobExpressionDeserializer.class)
@Getter
public class JobExpression {
    private final String expression;
    private final Long id;
    private final String status;

    public JobExpression(String expression){
        this.expression = expression;
        id = null;
        status = null;
    }

    public JobExpression(Long id, String expression){
        this.expression = expression;
        this.id = id;
        status = null;
    }

    public JobExpression(Long id){
        this.id = id;
        expression = null;
        status = null;
    }
}
