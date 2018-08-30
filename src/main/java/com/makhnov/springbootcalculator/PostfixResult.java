package com.makhnov.springbootcalculator;

import com.makhnov.springbootcalculator.factory.OperatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@Component
public class PostfixResult {
    @Autowired
    private OperatorFactory operatorFactory;

    public String getResult(String postfix_expression){
        Stack<Double> numbersStack = new Stack();
        List<String> strings = Arrays.asList(postfix_expression.split("[ ]"));
        for (int i = 0; i < strings.size(); i++) {
            String symbol = String.valueOf(strings.get(i));
            if (symbol.matches("\\d+")) {
                double number = Double.parseDouble(symbol);
                numbersStack.add(number);
            } else {
                double lastNumber = numbersStack.pop();
                double beforeLastNumber = numbersStack.pop();
                double result = operatorFactory.calculate(symbol, lastNumber, beforeLastNumber);
                numbersStack.add(result);
            }
        }
        return numbersStack.pop().toString();
    }
}
