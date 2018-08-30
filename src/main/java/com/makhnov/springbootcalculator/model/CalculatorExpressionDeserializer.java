package com.makhnov.springbootcalculator.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class CalculatorExpressionDeserializer extends JsonDeserializer {
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String postfixExpression = node.get("postfixExpression").textValue();
        double expectedResult = node.get("expectedResult").doubleValue();
        return new CalculatorExpression(postfixExpression, expectedResult);
    }
}
