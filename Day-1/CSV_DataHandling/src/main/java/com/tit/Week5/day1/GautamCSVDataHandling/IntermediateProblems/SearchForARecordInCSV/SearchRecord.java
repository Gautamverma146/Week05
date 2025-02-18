package com.tit.Week5.day1.GautamCSVDataHandling.IntermediateProblems.SearchForARecordInCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) {
        String filePath ="C:/Gautam/Week-5/Day-1/CSV_DataHandling/src/main/java/com/tit/Week5/day1/GautamCSVDataHandling/IntermediateProblems/SearchForARecordInCSV/emplyoee.csv";
         try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
             String line;
             boolean isHeader = true;
             while((line = br.readLine()) != null){
                 if(isHeader){
                     isHeader = false;
                     continue;
                 }
                 String[] data = line.split(",");
                 if(data.length<3){
                     continue;
                 }
                 String targetName = data[1];

                 if(targetName.equals("Gautam")){
                     System.out.println(line);
                 }
             }
             System.out.println();
         }
         catch (IOException e){
             System.out.println("Exceptionn Handled ");
             e.printStackTrace();
         }
    }
}
