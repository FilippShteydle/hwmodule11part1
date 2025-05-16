package com.shteydle.top.practice;

public class Car {
    private String brand;
    private String model;
    private double volume;
    private int year;
    private String color;
    private Category category;

    public Car(String brand, String model, double volume, int year, String color, Category category) {
        this.brand = brand;
        this.model = model;
        this.volume = volume;
        this.year = year;
        this.color = color;
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", volume=" + volume +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", category=" + category +
                '}';
    }
}
