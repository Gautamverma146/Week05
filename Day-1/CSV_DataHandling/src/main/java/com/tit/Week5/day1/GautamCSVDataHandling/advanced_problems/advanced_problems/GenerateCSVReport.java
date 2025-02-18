package com.tit.day01.advanced_problems;

import java.io.*;
import java.sql.*;

public class GenerateCSVReport {

    public static void main(String[] args) {
        // Database connection parameters
        String jdbcURL = "jdbc:mysql://localhost:3306/drshny_data_base";
        String username = "drshny03";  // Replace with your DB username
        String password = "Drshn@003";  // Replace with your DB password

        // SQL query to fetch employee data
        String query = "SELECT employee_id, name, department, salary FROM employees";
        // CSV file path

        String csvFile = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\databasecsv.csv";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);

             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            // Write the CSV headers
            writer.write("Employee ID,Name,Department,Salary\n");

            // Iterate through the result set and write to CSV
            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                // Write the data to CSV
                writer.write(employeeId + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("CSV report generated successfully: " + csvFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
