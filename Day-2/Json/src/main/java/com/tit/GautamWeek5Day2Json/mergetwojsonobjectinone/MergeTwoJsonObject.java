package com.tit.GautamWeek5Day2Json.mergetwojsonobjectinone;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class MergeTwoJsonObject {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode1 = (ObjectNode) objectMapper.readTree(new File("C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/mergetwojsonobjectinone/json1.json"));
        ObjectNode objectNode2 = (ObjectNode) objectMapper.readTree(new File("C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/mergetwojsonobjectinone/json2.json"));

        Iterator<Map.Entry<String, JsonNode>> iterator = objectNode2.fields();

        while (iterator.hasNext()){
            Map.Entry<String,JsonNode> fields = iterator.next();
            objectNode1.set(fields.getKey(),fields.getValue());
        }
        System.out.println("Merged :");
        objectMapper.writeValue(new File("C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/mergetwojsonobjectinone/merged.json"), objectNode1);
    }
}
