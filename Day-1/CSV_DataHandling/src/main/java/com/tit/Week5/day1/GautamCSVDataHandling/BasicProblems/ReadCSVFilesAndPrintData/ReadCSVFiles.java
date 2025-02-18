package com.tit.Week5.day1.GautamCSVDataHandling.BasicProblems.ReadCSVFilesAndPrintData;
//importing Buffered Reader to read CSV Files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFiles {
    public static void main(String[] args) {
        //Adding file path
        String file = "C:/Gautam/Week-5/Day-1/CSV_DataHandling/src/main/java/com/tit/Week5/day1/GautamCSVDataHandling/BasicProblems/ReadCSVFilesAndPrintData/file.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            //Reading line by line
            while((line = br.readLine()) != null){
                String[] columns = line.split(",");
                System.out.println("ID: " + columns[0] + ", Name: " + columns[1] + ", Age: " + columns[2] + ", Salary: "+columns[3] );
            }
        }
        //Handling Exception
        catch (IOException e){
            System.out.println("Exception handled");
            e.printStackTrace();
        }
    }
}
