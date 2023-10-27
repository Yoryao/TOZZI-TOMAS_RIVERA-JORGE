package com.backend.parcial.service;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class OdontologoService {
    Logger log = Logger.getLogger("OdontologServiceTest.class");

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    ;

    public Odontologo registrarOdontologo(Odontologo odontologo) throws SQLException {
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> buscarOdontologo() throws SQLException {
        log.info("BuscarOdontologo");

       return odontologoIDao.listar();

    }

}
