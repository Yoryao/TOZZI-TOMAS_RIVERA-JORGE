package com.backend.parcial.dao.Impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.dbConnection.ConnectionH2;
import com.backend.parcial.model.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OdontologoH2Dao implements IDao<Odontologo> {

    Logger log = Logger.getLogger("OdontologH2Dao.class");

    @Override
    public Odontologo guardar(Odontologo odontologo) throws SQLException {

        Connection connection = null;
        Odontologo odontologoRegistrado = null;

        try {
            connection = ConnectionH2.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (apellido, nombre, matricula) VALUES ( ? , ? , ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getApellido());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setInt(3, odontologo.getMatricula());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
    //      ResultSet resultSet = preparedStatement.getGeneratedKeys();

            
            odontologoRegistrado = new Odontologo(odontologo.getApellido(), odontologo.getNombre(), odontologo.getMatricula());

            while (resultSet.next()) {
                odontologoRegistrado.setId(resultSet.getInt("ID"));
            }
            connection.commit();
            log.info("Se registro un Odontologo: " + odontologoRegistrado);
        } catch (Exception e) {
            log.info("Error durante la conexion.");
            log.info(e.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                    log.info("Error de Conexion.");
                } catch (SQLException exception) {
                    log.info("Error de Conexion.");
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                log.info("No se pudo cerrar la conexion");
            }
        }

        return odontologoRegistrado;
    }

    @Override
    public List<Odontologo> listar() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        log.info("Voy a consultar..");

        try {
            log.info("entro al try");

            connection = ConnectionH2.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            log.info("no pudo consultar.");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Odontologo odontologo = crearObjetoOdontologo(resultSet);
                log.info("OD: " + odontologo.getApellido());
                odontologos.add(odontologo);
            }

            log.info("Se agregaron los odontologos a la lista.");

        } catch (Exception e) {
            log.info("Error recuperando la lista");
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                log.info("No se pudo cerrar la conexion");
            }
        }
        return odontologos;
    }

    private Odontologo crearObjetoOdontologo(ResultSet resultSet) throws SQLException {
        return new Odontologo(resultSet.getString("APELLIDO"), resultSet.getString("NOMBRE"), resultSet.getInt("MATRICULA"), resultSet.getInt("ID"));
    }

}

