package com.tit.day01.advanced_problems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MergeCSV {

    public static void main(String[] args) {
        String filePath1 = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\mergestudent01.csv";
        String filePath2 = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\mergestudent02.csv";
        String newFilePath = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\mergenewstudent.csv";

        List<String[]> studentsData1 = new ArrayList<>();
        List<String[]> studentsData2 = new ArrayList<>();

        // Read first CSV file (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(filePath1))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                studentsData1.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read second CSV file (ID, Marks, Grade)
        try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                studentsData2.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write merged data to new CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFilePath))) {
            bw.write("ID,Name,Age,Marks,Grade\n");

            for (String[] student1 : studentsData1) {
                for (String[] student2 : studentsData2) {
                    if (student1[0].equals(student2[0])) {
                        String mergedData = String.join(",", student1[0], student1[1], student1[2], student2[1], student2[2]);
                        bw.write(mergedData + "\n");
                    }
                }
            }

            System.out.println("Merged file created successfully: " + newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
