package com.makhnov.springbootcalculator.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class JobExpressionDeserializer extends JsonDeserializer {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String expression = node.get("expression").textValue();
        return new JobExpression(expression);
    }
}
