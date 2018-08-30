package com.makhnov.springbootcalculator.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@JsonDeserialize(using = CalculatorExpressionDeserializer.class)
@AllArgsConstructor
@Getter
public class CalculatorExpression implements Serializable {

    private final String postfixExpression;
    private final double expectedResult;
}
