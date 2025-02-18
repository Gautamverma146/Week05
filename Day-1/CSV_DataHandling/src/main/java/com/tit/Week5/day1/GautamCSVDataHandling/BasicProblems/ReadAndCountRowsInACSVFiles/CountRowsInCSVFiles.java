package com.tit.Week5.day1.GautamCSVDataHandling.BasicProblems.ReadAndCountRowsInACSVFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsInCSVFiles {
    public static void main(String[] args) {
        String filepath = "C:/Gautam/Week-5/Day-1/CSV_DataHandling/src/main/java/com/tit/Week5/day1/GautamCSVDataHandling/BasicProblems/ReadAndCountRowsInACSVFiles/file3.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            int rowCount = 0;
            boolean isHeader = true;
            while ((line = br.readLine()) != null){
                if(isHeader ){
                    isHeader = false;
                    continue;
                }
                rowCount++;
            }
            System.out.println("NUmber of rows excluding header: " + rowCount);
        }
        catch (IOException e){
            System.out.println("Exception Handled ");
                e.printStackTrace();
        }
    }
}
