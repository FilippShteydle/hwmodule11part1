package com.shteydle.top.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDBS {
    private String url;
    private String username;
    private String password;

    public ConnectToDBS(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection joiningToDBS () {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String disablingToDBS(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "База отключена";
    }
}
