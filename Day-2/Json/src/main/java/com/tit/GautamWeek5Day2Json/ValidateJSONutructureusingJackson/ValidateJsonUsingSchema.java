package com.tit.GautamWeek5Day2Json.ValidateJSONutructureusingJackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class ValidateJsonUsingSchema {
    public static void main(String[] args) throws IOException, JsonProcessingException, ProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode schemaNode = objectMapper.readTree(new File("C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/ValidateJSONutructureusingJackson/schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);

        JsonNode jsonData = objectMapper.readTree(new File("C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/ValidateJSONutructureusingJackson/check.json"));
        if (schema.validate(jsonData).isSuccess()) {
            System.out.println("JSON is valid!");
        }
else {
            System.out.println("Invalid json");
        }
    }
}
