package com.tit.GautamWeek5Day2Json.ReadJsonAndPrintAllKeysAndValues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonAndPrint {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/ReadJsonAndPrintAllKeysAndValues/file.json"));

        Iterator<Map.Entry<String,JsonNode>> iterator = jsonNode.fields();
        while (iterator.hasNext()){
            Map.Entry<String,JsonNode> entry = iterator.next();
            System.out.println(entry.getKey()+" -> "+ entry.getValue());
        }
    }
}
