package com.makhnov.springbootcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PostfixResult {
    public String getResult(String string){
        Stack<Double> numbersStack = new Stack();
        List<String> strings = Arrays.asList(string.split("[ ]"));
        for (int i = 0; i < strings.size(); i++) {
            String symbol = String.valueOf(strings.get(i));
            if (symbol.matches("\\d+")) {
                double number = Double.parseDouble(symbol);
                numbersStack.add(number);
            } else {
                if (symbol.matches("[*]")) {
                    double lastNumber = numbersStack.pop();
                    double beforeLastNumber = numbersStack.pop();
                    double result = lastNumber*beforeLastNumber;
                    numbersStack.add(result);
                } else {
                    if (symbol.matches("[+]")) {
                        double lastNumber = numbersStack.pop();
                        double beforeLastNumber = numbersStack.pop();
                        double result = lastNumber+beforeLastNumber;
                        numbersStack.add(result);
                    } else {
                        if (symbol.matches("[-]")) {
                            double lastNumber = numbersStack.pop();
                            double beforeLastNumber = numbersStack.pop();
                            double result = lastNumber-beforeLastNumber;
                            numbersStack.add(result);
                        } else {
                            if (symbol.matches("[/]")) {
                                double lastNumber = numbersStack.pop();
                                double beforeLastNumber = numbersStack.pop();
                                double result = lastNumber/beforeLastNumber;
                                numbersStack.add(result);
                            }
                        }
                    }
                }
            }
        }
        return numbersStack.pop().toString();
    }
}
