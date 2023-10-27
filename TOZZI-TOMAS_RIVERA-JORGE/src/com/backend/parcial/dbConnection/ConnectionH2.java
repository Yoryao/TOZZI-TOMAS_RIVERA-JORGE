package com.backend.parcial.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionH2 {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/parcial;", "sa", "sa");

    }

}
