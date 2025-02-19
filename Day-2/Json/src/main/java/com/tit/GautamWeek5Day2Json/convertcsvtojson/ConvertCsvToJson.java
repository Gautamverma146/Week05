package com.tit.GautamWeek5Day2Json.convertcsvtojson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConvertCsvToJson {
    public static void main(String[] args) {
        try {
            // Read CSV file
            File csvFile = new File("C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/convertcsvtojson/csvfile.csv");

            //  Create CSV schema and read data
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(csvFile);

            List<Map<String, String>> data = iterator.readAll();

            // Convert to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

            //  Print JSON output
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
