package com.backend.parcial;

import com.backend.parcial.dbConnection.ConnectionH2;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    public static final Logger LOG = Logger.getLogger("Main.java");


    //Declaro las sentencias para utilizar.
    private static final String CREATE = "DROP TABLE IF EXISTS CUENTAS; CREATE TABLE CUENTAS (ID INT PRIMARY KEY AUTO_INCREMENT, NOMBRE VARCHAR(100) NOT NULL, NUMERO_CUENTA INT NOT NULL, SALDO NUMERIC(10, 2) NOT NULL)";
    private static final String INSERT = "INSERT INTO CUENTAS (NOMBRE, NUMERO_CUENTA, SALDO) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE CUENTAS SET SALDO = ? WHERE NUMERO_CUENTA = ?";
    private static final String SELECT = "SELECT * FROM CUENTAS WHERE NUMERO_CUENTA = ?";

    public static void main(String[] args) {

        Connection conn = null;

        try {
            conn = ConnectionH2.getConnection();
            conn.setAutoCommit(false);





            LOG.info("Connecion establecida.");
            conn.commit();
        } catch (Exception exception) {
            LOG.error("Se produjo una Excepcion: " + exception.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    LOG.info("Se realizo un rollback debido a " + exception.getMessage());
                } catch (SQLException ex) {
                    LOG.error(ex.getMessage());
                }
            }
        } finally {
            try {
                conn.close();
                LOG.error("Se Cerro la conexion");

            } catch (Exception exception) {
                LOG.error("Se produjo una Excepcion: " + exception.getMessage());
            }
        }
    }
}
