package com.tit.GautamWeek5Day2Json.ConvertListOfObjectInJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters (Jackson needs them for serialization)
    public String getName() { return name; }
    public int getAge() { return age; }
}

public class ListToJsonArray {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Creating a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("Gautam", 25),
                new Person("John", 30),
                new Person("Alice", 28)
        );

        // Convert the list to a JSON array
        String jsonArray = objectMapper.writeValueAsString(people);

        // Print JSON array
        System.out.println(jsonArray);
    }
}

