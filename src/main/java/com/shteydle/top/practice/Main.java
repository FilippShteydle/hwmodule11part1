package com.shteydle.top.practice;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:postgresql://localhost:5432/cars";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        CarService service = new CarService();

        Car car1 = new Car("BMW", "X6", 3.5, 2018, "Black", Category.HATCHBACK);
        Car car2 = new Car("BMW", "M5", 2.0, 2020, "Red", Category.SEDAN);
        Car car3 = new Car("Toyota", "Camry", 3.5, 2022, "Grey", Category.SEDAN);
        Car car4 = new Car("Audi", "B4", 2.6, 2013, "Black", Category.STATION_WAGON);
        Car car5 = new Car("Audi", "Q5", 3.0, 2018, "Green", Category.STATION_WAGON);

        Connection connection = service.joiningToDBS(URL, USERNAME, PASSWORD);

        /*service.insertCar(connection, car1);
        service.insertCar(connection, car2);
        service.insertCar(connection, car3);
        service.insertCar(connection, car4);
        service.insertCar(connection, car5);*/


        service.showAllCars(connection);
        service.showAllBrands(connection);
        System.out.println("--------------");
        service.showQuantityForBrands(connection);
        System.out.println("--------------");
        service.showCarsBetweenYears(connection, 2019, 2023);
        System.out.println("--------------");
        service.showCarsByCategory(connection, Category.STATION_WAGON);
        System.out.println("--------------");
        service.deleteCar(connection, 3);
        System.out.println("--------------");
        service.updateCar(connection, "color", "DarkGrey", 1);
        System.out.println("--------------");
        service.updateCar(connection, "year", 2021, 2);
        System.out.println("--------------");
        service.updateCar(connection, "volume", 2.8, 4);
        System.out.println("--------------");

        service.showAllCars(connection);

        System.out.println(service.disablingToDBS(connection));

    }
}