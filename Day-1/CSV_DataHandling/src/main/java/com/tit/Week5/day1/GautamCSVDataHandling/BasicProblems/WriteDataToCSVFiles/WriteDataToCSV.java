package com.tit.Week5.day1.GautamCSVDataHandling.BasicProblems.WriteDataToCSVFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToCSV {
    public static void main(String[] args) {


        String file2 = "C:/Gautam/Week-5/Day-1/CSV_DataHandling/src/main/java/com/tit/Week5/day1/GautamCSVDataHandling/BasicProblems/WriteDataToCSVFiles/file.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
            writer.write("ID,Name,Department,Age,Salary\n");
            writer.write("0111,Gautam,AIML,22,425000\n");
            writer.write("0112,Ayush,21,400000\n");
            writer.write("0113,Nitish,23,450000");

        } catch (IOException e) {
            System.out.println("Exception Handled");
            e.printStackTrace();
        }

    }
}
