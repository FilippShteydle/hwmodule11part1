package com.shteydle.top.practice;

import java.sql.Connection;

public class CarService {

    private CarsRepository repository = new CarsRepository();

    public Connection joiningToDBS(String url, String username, String password) {

        return repository.joiningToDBS(url, username, password);
    }

    public String disablingToDBS (Connection connection) {
        return repository.disablingToDBS(connection);
    }

    public void insertCar(Connection connection, Car car) {
        repository.insertCar(connection, car);
    }

    public void showAllCars(Connection connection) {
        repository.showAllCars(connection);
    }

    public void showAllBrands(Connection connection) {
        repository.showAllBrands(connection);
    }

    public void showQuantityForBrands(Connection connection) {
        repository.showQuantityForBrands(connection);
    }

    public void showCarsBetweenYears(Connection connection, int year1, int year2) {
        repository.showCarsBetweenYears(connection, year1, year2);
    }

    public void showCarsByCategory(Connection connection, Category category) {
        repository.showCarsByCategory(connection, category.toString());
    }

    public void deleteCar(Connection connection, int id) {
        repository.deleteCar(connection, id);
    }

    public void updateCar(Connection connection, String column, String value, int id) {
        repository.updateCar(connection, column, value, id);
    }

    public void updateCar(Connection connection, String column, int value, int id) {
        repository.updateCar(connection, column, value, id);
    }

    public void updateCar(Connection connection, String column, double value, int id) {
        repository.updateCar(connection, column, value, id);
    }
}
