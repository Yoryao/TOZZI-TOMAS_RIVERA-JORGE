package com.backend.parcial.test;

import com.backend.parcial.dao.Impl.OdontologoH2Dao;
import com.backend.parcial.model.Odontologo;
import com.backend.parcial.service.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class OdontologoServiceTest {

    Logger log = Logger.getLogger("OdontologServiceTest.class");

    private OdontologoService odontologoService;


    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/parcial; INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }











    @Test
    public void deberiaAgregarYRetornarUnOdontologoEnH2() throws SQLException {
        OdontologoService odontologoService = new OdontologoService(new OdontologoH2Dao());
        Odontologo odontologo = new Odontologo("Ruiz", "Leonardo", 125);
        Odontologo odontologoPersistido = odontologoService.registrarOdontologo(odontologo);

        Assertions.assertTrue(odontologoPersistido.getId() != 0);
    }

    @Test
    public void debeRetornarListaOdontologos() throws SQLException {

        assertFalse(odontologoService.buscarOdontologo().isEmpty());

    }


}