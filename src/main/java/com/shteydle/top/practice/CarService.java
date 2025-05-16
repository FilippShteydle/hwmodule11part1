package com.shteydle.top.practice;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Stream;

public class CarService {

    private CarsRepository repository = new CarsRepository();

    public String joiningToDBS(String url, String username, String password) {

        return repository.joiningToDBS(url, username, password);
    }

    public String disablingToDBS() {
        return repository.disablingToDBS();
    }

    public void insertCar(Car car) {
        repository.insertCar(car);
    }

    public void showAllCars() {
        List<Car> cars = repository.showAllCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void showAllBrands() {
        repository.showAllBrands();
    }

    public void showQuantityForBrands() {
        List<String> countCars = repository.showQuantityForBrands();
        for (String str : countCars) {
            System.out.println(str);
        }
    }

    public void showCarsBetweenYears(int year1, int year2) {
        repository.showCarsBetweenYears(year1, year2);
    }

    public void showCarsByCategory(Category category) {
        repository.showCarsByCategory(category.toString());
    }

    public void deleteCar(int id) {
        repository.deleteCar(id);
    }

    public void updateCar(String column, String value, int id) {
        repository.updateCar(column, value, id);
    }

    public void updateCar(String column, int value, int id) {
        repository.updateCar(column, value, id);
    }

    public void updateCar(String column, double value, int id) {
        repository.updateCar(column, value, id);
    }
}
