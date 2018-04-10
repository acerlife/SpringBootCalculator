package com.makhnov.springbootcalculator;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CalculatorExpressionDeserializer.class)
public class CalculatorExpression{

    private final String postfixExpression;
    private final double expectedResult;

    public CalculatorExpression(String postfixExpression, double expectedResult){
        this.postfixExpression = postfixExpression;
        this.expectedResult = expectedResult;
    }

    public String getPostfixExpression() {
        return postfixExpression;
    }

    public double getExpectedResult() {
        return expectedResult;
    }
}
