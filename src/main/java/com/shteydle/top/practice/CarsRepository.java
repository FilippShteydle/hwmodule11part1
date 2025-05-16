package com.shteydle.top.practice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarsRepository {
    private ConnectToDBS connect;
    private Connection connection;

    private static final String INSERT = "INSERT INTO cars (brand, model, volume, year, color, category) VALUES (?, ?, ?, ?, ?, ?)";

    public String joiningToDBS(String url, String username, String password) {
        connect = new ConnectToDBS(url, username, password);
        connection = connect.joiningToDBS();
        return "База подключена";
    }

    public String disablingToDBS() {
        return connect.disablingToDBS(connection);
    }

    public List<Car> showAllCars() {
        String selectAll = "select * from cars";
        List<Car> cars = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(selectAll)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cars.add(new Car(resultSet.getString(2), resultSet.getString(3),
                        resultSet.getDouble(4), resultSet.getInt(5),
                        resultSet.getString(6), getCategory(resultSet.getString(7))));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cars;
    }

    public void showAllBrands() {
        String selectAll = "select distinct brand from cars";

        try (PreparedStatement statement = connection.prepareStatement(selectAll)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> showQuantityForBrands() {
        String selectBrand = "select brand, count(*) from cars group by brand";
        List<String> countCars = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(selectBrand)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                countCars.add("Brand: " + resultSet.getString(1) + ", quantity cars: " + resultSet.getInt(2));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return countCars;
    }

    public void showCarsBetweenYears(int year1, int year2) {
        String selectBetweenYear = "select * from cars where year between ? and ?";

        try (PreparedStatement statement = connection.prepareStatement(selectBetweenYear)) {
            statement.setInt(1, year1);
            statement.setInt(2, year2);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(new Car(resultSet.getString(2), resultSet.getString(3),
                        resultSet.getDouble(4), resultSet.getInt(5),
                        resultSet.getString(6), getCategory(resultSet.getString(7))));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showCarsByCategory(String category) {
        String selectByCategory = "select * from cars where category = ?";

        try (PreparedStatement statement = connection.prepareStatement(selectByCategory)) {
            statement.setString(1, category);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(new Car(resultSet.getString(2), resultSet.getString(3),
                        resultSet.getDouble(4), resultSet.getInt(5),
                        resultSet.getString(6), getCategory(resultSet.getString(7))));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private Category getCategory(String category) {
        for (Category cat : Category.values()) {
            if (cat.toString().equals(category)) {
                return cat;
            }
        }
        return null;
    }

    public void insertCar(Car car) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setDouble(3, car.getVolume());
            statement.setInt(4, car.getYear());
            statement.setString(5, car.getColor());
            statement.setString(6, String.valueOf(car.getCategory()));

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCar(int id) {
        String deleteCar = "delete from cars where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(deleteCar)) {
            statement.setInt(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCar(String column, String value, int id) {
        String updateCar = createRequest(column);

        try (PreparedStatement statement = connection.prepareStatement(updateCar)) {
            statement.setString(1, value);
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCar(String column, int value, int id) {
        String updateCar = createRequest(column);

        try (PreparedStatement statement = connection.prepareStatement(updateCar)) {
            statement.setInt(1, value);
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCar(String column, double value, int id) {
        String updateCar = createRequest(column);

        try (PreparedStatement statement = connection.prepareStatement(updateCar)) {
            statement.setDouble(1, value);
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private String createRequest(String column) {
        return "update cars set " + column + " = ? where id = ?";
    }
}
