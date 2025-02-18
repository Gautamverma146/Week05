package com.tit.day01.advanced_problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {


    public static void main(String[] args) {
        String inputFile = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\largefile.csv";
        int chunkSize = 100; // Process 100 lines at a time
        int lineCount = 0;
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineCount++;
                // Process the line (e.g., print, parse, etc.)
                System.out.println(line); // Example: Display the line

                if (lineCount == chunkSize) {
                    recordCount += lineCount;
                    System.out.println("Processed " + recordCount + " records.");
                    lineCount = 0; // Reset the counter for the next chunk
                }
            }

            // Handle the remaining lines if the file doesn't end on a chunk boundary
            if (lineCount > 0) {
                recordCount += lineCount;
                System.out.println("Processed " + recordCount + " records.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
