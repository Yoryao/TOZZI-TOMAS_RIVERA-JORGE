package com.backend.parcial.dbConnection;

import java.sql.*;

public class ConnectionH2 {

    public static Connection getConnection() throws SQLException, ClassNotFoundException{

        Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:~/parcial", "sa", "sa");

    }

}
