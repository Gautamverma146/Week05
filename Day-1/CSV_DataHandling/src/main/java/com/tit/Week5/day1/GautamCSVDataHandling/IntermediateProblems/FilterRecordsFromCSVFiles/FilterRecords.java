package com.tit.Week5.day1.GautamCSVDataHandling.IntermediateProblems.FilterRecordsFromCSVFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        String filepath = "C:/Gautam/Week-5/Day-1/CSV_DataHandling/src/main/java/com/tit/Week5/day1/GautamCSVDataHandling/IntermediateProblems/FilterRecordsFromCSVFiles/students.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            boolean isHeader = true;
            while((line = br.readLine()) != null ){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");

                if(data.length<3){
                    continue;
                }
                int marks = Integer.parseInt(data[2]);
                if(marks>80){
                    System.out.println(line);
                }

            }

        }
        catch (IOException e){
            System.out.println("Exception Handled");
            e.printStackTrace();
        }
    }
}
