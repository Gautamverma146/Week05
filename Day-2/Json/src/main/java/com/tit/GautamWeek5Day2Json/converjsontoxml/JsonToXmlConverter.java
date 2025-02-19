package com.tit.GautamWeek5Day2Json.converjsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            //  Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/converjsontoxml/jsontoxml.json"));

            //  Convert to XML
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(jsonNode);

            //  Print XML output
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
