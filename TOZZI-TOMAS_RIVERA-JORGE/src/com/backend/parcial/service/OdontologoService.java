package com.backend.parcial.service;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;

import java.sql.SQLException;
import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    ;

    public Odontologo registrarOdontologo(Odontologo odontologo) throws SQLException {
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> buscarOdontologo() throws SQLException {
        return odontologoIDao.listar();
    }

}
