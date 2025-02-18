package com.tit.day01.advanced_problems;

import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String csvFile = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\duplicate.csv";
        String line;
        String cvsSplitBy = ",";

        // A list to store all IDs
        List<String> ids = new ArrayList<>();
        // A list to store duplicate records
        List<String> duplicates = new ArrayList<>();

        try  {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // Skip header

            // First pass to store all IDs
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                String id = data[0];  // Assuming ID is the first column
                ids.add(id);
            }

            // Second pass to find duplicates
            br.close();
            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // Skip header again

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                String id = data[0];

                // Count how many times this ID appears in the list
                if (Collections.frequency(ids, id) > 1) {
                    duplicates.add(line);
                }
            }

            // Print duplicate records
            if (!duplicates.isEmpty()) {
                System.out.println("Duplicate Records:");
                for (String record : duplicates) {
                    System.out.println(record);
                }
            } else {
                System.out.println("No duplicates found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
