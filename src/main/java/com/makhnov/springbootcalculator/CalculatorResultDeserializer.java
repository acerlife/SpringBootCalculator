package com.makhnov.springbootcalculator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.makhnov.springbootcalculator.model.CalculatorResult;

import java.io.IOException;

public class CalculatorResultDeserializer extends JsonDeserializer {
    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        double result = node.get("result").doubleValue();
        return new CalculatorResult(result);
    }
}
