package com.tit.Week5.day1.GautamCSVDataHandling.IntermediateProblems.ModifyACSVFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModifyCSVfile {
    public static void main(String[] args) {
        String filePath = "C:/Gautam/Week-5/Day-1/CSV_DataHandling/src/main/java/com/tit/Week5/day1/GautamCSVDataHandling/IntermediateProblems/ModifyACSVFile/employee1.csv";
        //String output =
        List<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null){
                if(isHeader){
                    isHeader=false;
                    continue;
                }

                String[] data = line.split(",");

                if(data.length<4){
                    continue;
                }
                String department = data[3];
                double salary = Double.parseDouble(data[2].trim());
                if(department.equalsIgnoreCase("IT")){
                    salary *= 1.10;
                }
                lines.add(data[0] + "," + data[1] + "," + department + "," + String.format("%.2f", salary));
            }

        }
        catch (IOException  e){
            System.out.println("Exception Handled");
            e.printStackTrace();
            e.getMessage();
        }
        try {
            Files.write(Paths.get(filePath), lines);
            System.out.println("Updated salaries saved in the same file.");
        }
        catch (IOException e){
            e.printStackTrace();
            e.printStackTrace();
        }
    }
}
