package com.backend.parcial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Application {

    static Logger log = Logger.getLogger("Application.class");

    public static void main(String[] args) throws SQLException {

        Connection connection = null;




        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/parcial;", "sa", "sa");
            log.info("Conecto");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
