package com.tit.GautamWeek5Day2Json.ReadJsonFileAndExtractSpecificField;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

//  Ignore unknown fields in JSON to prevent errors
@JsonIgnoreProperties(ignoreUnknown = true)
class ReferenceClassForField {
    private String name;
    private String email;

    // Default constructor required by Jackson
    public ReferenceClassForField() {}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

public class ExtractSpecificFieldFromJsonFile {
    public static void main(String[] args) {
        //  Path to JSON file (Update with your correct path)
        String filePath = "C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/ReadJsonFileAndExtractSpecificField/file.json";

        //  Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            //  Read JSON file and map to Java object
            ReferenceClassForField ref1 = objectMapper.readValue(new File(filePath), ReferenceClassForField.class);

            // Display extracted values
            System.out.println("Name: " + ref1.getName());
            System.out.println("Email: " + ref1.getEmail());
        }
        catch (IOException e) {
            // Print error if file reading fails
            System.err.println("Error reading JSON file: " + e.getMessage());
        }
    }
}
