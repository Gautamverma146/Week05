package com.tit.GautamWeek5Day2Json.ConvertJavaObjectInJsonFormat;

import org.json.JSONObject;

// Car class representing a car object with attributes
class Car {
    private String brand;
    private String model;
    private int year;
    private int seater;

    // Constructor to initialize Car object
    public Car(String brand, String model, int year, int seater) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.seater = seater;
    }

    // Getter methods to access private fields
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getSeater() {
        return seater;
    }
}

public class CarToJson {
    public static void main(String[] args) {
        // Creating a Car object with brand, model, year, and seating capacity
        Car newCar = new Car("Honda", "Sedan", 2003, 4);

        // Creating a JSONObject and adding Car details to it
        JSONObject json = new JSONObject();
        json.put("brand", newCar.getBrand());
        json.put("Model", newCar.getModel());
        json.put("Year", newCar.getYear());
        json.put("SeatingCapacity", newCar.getSeater());

        // Printing JSON representation of the Car object
        System.out.println("Car to JSON:");
        System.out.println(json.toString(4));
    }
}
