package com.makhnov.springbootcalculator.factory;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OperatorFactory {

    private final Map<String, Operator> operatorsMap;

    public OperatorFactory(List<Operator> operators) {
        operatorsMap = operators
                .stream()
                .collect(Collectors.toMap(Operator::getSymbol, Function.identity()));
    }

    public double calculate(String symbol, double lastNumber, double beforeLastNumber){
        return operatorsMap.get(symbol).calculate(lastNumber, beforeLastNumber);
    }
}
