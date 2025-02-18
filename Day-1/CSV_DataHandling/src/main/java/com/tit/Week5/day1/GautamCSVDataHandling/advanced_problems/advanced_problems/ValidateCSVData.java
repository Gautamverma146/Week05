package com.tit.day01.advanced_problems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.out;

public class ValidateCSVData{

    public static void main(String ar[]) throws FileNotFoundException {
        String filePath = "C:\\capgeminitraining\\Week-5\\CSV-Data-Handling\\src\\main\\resources\\validatedata.csv";


        FileReader reader = new FileReader(filePath);

        try(CSVReader csvReader =new CSVReader(reader))
        {
            String [] data;

            boolean header = true;


            while((data =csvReader.readNext())!=null) {
                if (header) {
                    header = false;
                    continue;
                }
                validateData(data);
            }
        }
        catch (FileNotFoundException e)
        {
            out.println("file not found");
        } catch (IOException e)
        {
            out.println("exception while reading file");
        } catch (CsvValidationException e)
        {
            out.println("data not valid");
        }

    }

    private static void validateData(String[] employee) {

        String regexNumber = "\\d{10}";
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        //validate email
        if(!employee[1].trim().matches(regexEmail)){
            out.println(employee[0] + "'s email not valid - " + employee[1]);
        }
        //validate number
        if(!employee[2].matches(regexNumber)){
            out.println(employee[0] + "'s number not valid - " + employee[2]);
}

    }

}
