package com.tit.GautamWeek5Day2Json.IPLAndcensorAnalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class IplCensorAnalyzer {
    public static void main(String[] args) {
        String jsonInputFile = "C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/IPLAndcensorAnalyzer/ipl.json";
        String csvInputFile = "C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/IPLAndcensorAnalyzer/ipl.csv";
        String jsonOutputFile = "C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/IPLAndcensorAnalyzer/iploutput.json";
        String csvOutputFile = "C:/Gautam/Week-5/Day-2/Json/src/main/java/com/tit/GautamWeek5Day2Json/IPLAndcensorAnalyzer/iploutput.csv";

        try {
            // Process JSON file
            List<Map<String, String>> jsonData = readJson(jsonInputFile);
            List<Map<String, String>> censoredJsonData = applyCensorship(jsonData);
            writeJson(censoredJsonData, jsonOutputFile);

            // Process CSV file
            List<Map<String, String>> csvData = readCsv(csvInputFile);
            List<Map<String, String>> censoredCsvData = applyCensorship(csvData);
            writeCsv(censoredCsvData, csvOutputFile);

            System.out.println(" Censorship applied and data written to files.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(" Error processing files: " + e.getMessage());
        }
    }

    // Read JSON file
    private static List<Map<String, String>> readJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), List.class);
    }

    // Write JSON file
    private static void writeJson(List<Map<String, String>> data, String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
    }


    private static List<Map<String, String>> readCsv(String filePath) throws IOException {
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        return csvMapper.readerFor(Map.class)
                .with(schema)
                .<Map<String, String>>readValues(new File(filePath))
                .readAll();
    }


    private static void writeCsv(List<Map<String, String>> data, String filePath) throws IOException {
        if (data.isEmpty()) return;
        CsvSchema schema = CsvSchema.builder()
                .addColumns(data.get(0).keySet(), CsvSchema.ColumnType.STRING)
                .setUseHeader(true)
                .build();

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writer(schema).writeValue(new File(filePath), data);
    }

    // Apply censorship rules
    private static List<Map<String, String>> applyCensorship(List<Map<String, String>> data) {
        List<Map<String, String>> censoredData = new ArrayList<>();
        for (Map<String, String> match : data) {
            Map<String, String> censoredMatch = new HashMap<>();
            for (Map.Entry<String, String> entry : match.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.equalsIgnoreCase("team1") || key.equalsIgnoreCase("team2")) {
                    value = censorTeamName(value);
                }
                if (key.equalsIgnoreCase("player_of_match")) {
                    value = "REDACTED";
                }
                censoredMatch.put(key, value);
            }
            censoredData.add(censoredMatch);
        }
        return censoredData;
    }

    // Censor team names (Mask last word)
    private static String censorTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
        }
        return String.join(" ", words);
    }
}
