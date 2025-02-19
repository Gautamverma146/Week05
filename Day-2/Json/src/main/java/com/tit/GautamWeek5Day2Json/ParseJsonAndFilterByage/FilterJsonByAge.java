package com.tit.GautamWeek5Day2Json.ParseJsonAndFilterByage;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;

public class FilterJsonByAge {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON from file
        File jsonFile = new File("C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/ParseJsonAndFilterByage/jsonfile.json");
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        // Ensure it's an array
        if (rootNode.isArray()) {
            ArrayNode filteredArray = objectMapper.createArrayNode();

            for (JsonNode node : rootNode) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    filteredArray.add(node);
                }
            }

            // Print filtered JSON
            System.out.println("Filtered JSON Array:");
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredArray));
        } else {
            System.out.println("JSON is not an array!");
        }
    }
}
