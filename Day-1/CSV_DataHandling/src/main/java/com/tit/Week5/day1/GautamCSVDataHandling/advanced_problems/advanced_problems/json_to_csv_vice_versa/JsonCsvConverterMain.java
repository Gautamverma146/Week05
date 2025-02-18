package com.tit.day01.advanced_problems.json_to_csv_vice_versa;

public class JsonCsvConverterMain {
    public static void main(String[] args) {
        //define file path
        String jsonFilePath = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\student.json";
        String csvFilePath = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\student.csv";
        String outputJsonFilePath = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\studentoutput.json";

        // convert csv back to json
        CsvToJsonConverter.convert(csvFilePath, outputJsonFilePath);
        // convert json to csv
        JsonToCsvConverter.convert(jsonFilePath, csvFilePath);
    }

}
