package com.tit.Week5.day1.GautamCSVDataHandling.IntermediateProblems.SortCSVByCollumn;

import java.io.*;
import java.util.*;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class SortCsvSalary {
    public static void main(String[] args) {
        String filePath = "C:/Gautam/Week-5/Day-1/CSV_DataHandling/src/main/java/com/tit/Week5/day1/GautamCSVDataHandling/IntermediateProblems/SortCSVByCollumn/employee3.csv"; // Update with your CSV file path
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 2) { // Ensure proper data format
                    try {
                        String name = data[0].trim();
                        double salary = Double.parseDouble(data[2].trim());
                        employees.add(new Employee(name, salary));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid salary: " + data[1]);
                    }
                } else {
                    System.err.println("Skipping invalid row: " + Arrays.toString(data));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        System.out.println("Top 5 highest-paid employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(employees.get(i).name + " - " + employees.get(i).salary);
        }
    }
}
